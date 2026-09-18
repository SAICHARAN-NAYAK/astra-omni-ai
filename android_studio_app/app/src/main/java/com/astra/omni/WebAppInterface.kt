package com.astra.omni

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.webkit.JavascriptInterface
import android.widget.Toast
import org.json.JSONObject

/**
 * JavaScript Interface exposing native Android device capabilities
 * to the ASTRA OMNI HTML/JS client.
 */
class WebAppInterface(private val context: Context) {

    private val prefs = context.getSharedPreferences("astra_omni_prefs", Context.MODE_PRIVATE)

    @JavascriptInterface
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun triggerHaptic(severity: String) {
        try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val manager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                manager?.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            }

            if (vibrator != null && vibrator.hasVibrator()) {
                val durationMs = when (severity.uppercase()) {
                    "CRITICAL" -> 250L
                    "HIGH" -> 120L
                    else -> 40L
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val amplitude = when (severity.uppercase()) {
                        "CRITICAL" -> VibrationEffect.DEFAULT_AMPLITUDE
                        "HIGH" -> 180
                        else -> 80
                    }
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(durationMs, amplitude)
                    )
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(durationMs)
                }
            }
        } catch (_: Exception) {
            // Graceful fallback on devices without vibrator permissions
        }
    }

    @JavascriptInterface
    fun getNetworkStatus(): String {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetwork ?: return "OFFLINE"
        val caps = cm.getNetworkCapabilities(activeNetwork) ?: return "OFFLINE"

        return when {
            caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WIFI"
            caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "CELLULAR"
            caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "ETHERNET"
            else -> "CONNECTED"
        }
    }

    @JavascriptInterface
    fun openExternalLink(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            showToast("Cannot open link: ${e.localizedMessage}")
        }
    }

    @JavascriptInterface
    fun setCustomServerUrl(url: String) {
        prefs.edit().putString("custom_server_url", url.trim()).apply()
        showToast("Endpoint saved. Reloading...")
    }

    @JavascriptInterface
    fun getCustomServerUrl(): String {
        return prefs.getString("custom_server_url", "") ?: ""
    }

    @JavascriptInterface
    fun getDeviceInfo(): String {
        return JSONObject().apply {
            put("brand", Build.BRAND)
            put("model", Build.MODEL)
            put("sdkVersion", Build.VERSION.SDK_INT)
            put("appVersion", "1.0.0")
            put("network", getNetworkStatus())
        }.toString()
    }
}
