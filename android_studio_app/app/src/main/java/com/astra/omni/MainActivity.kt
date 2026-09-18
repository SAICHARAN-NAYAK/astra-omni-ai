package com.astra.omni

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.webkit.PermissionRequest
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * ASTRA OMNI AI // Unified Autonomous Multimodal AI Engine
 * Native Android Container with hardware-accelerated WebView hosting HTML5/JS core.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        swipeRefresh = findViewById(R.id.swipeRefreshLayout)
        webView = findViewById(R.id.webView)

        configureWebView()
        setupSwipeRefresh()
        setupBackNavigation()
        requestAppPermissions()

        loadApplication()
    }

    private fun requestAppPermissions() {
        val permissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS
        )
        val missingPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        if (missingPermissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, missingPermissions.toTypedArray(), 101)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun configureWebView() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            allowFileAccess = true
            allowContentAccess = true
            mediaPlaybackRequiresUserGesture = false

            // Performance optimizations
            cacheMode = WebSettings.LOAD_DEFAULT
            setRenderPriority(WebSettings.RenderPriority.HIGH)
            useWideViewPort = true
            loadWithOverviewMode = true
            builtInZoomControls = false
            displayZoomControls = false

            // Local resource access
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        // Expose native Android bridge to JS
        webView.addJavascriptInterface(WebAppInterface(this), "AndroidBridge")

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                swipeRefresh.isRefreshing = false
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                // Fall back to bundled offline assets if remote fails
                if (request?.isForMainFrame == true) {
                    webView.loadUrl("file:///android_asset/index.html")
                }
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                progressBar.progress = newProgress
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }
            }

            override fun onPermissionRequest(request: PermissionRequest?) {
                runOnUiThread {
                    request?.grant(request.resources)
                }
            }

            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                return true
            }
        }

        // Hardware acceleration
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
    }

    private fun setupSwipeRefresh() {
        swipeRefresh.setColorSchemeColors(
            getColor(R.color.accent_blue),
            getColor(R.color.accent_emerald),
            getColor(R.color.accent_crimson)
        )
        swipeRefresh.setOnRefreshListener {
            webView.reload()
        }
    }

    private fun setupBackNavigation() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    private fun loadApplication() {
        val customUrl = getSharedPreferences("astra_omni_prefs", MODE_PRIVATE)
            .getString("custom_server_url", null)

        if (!customUrl.isNullOrBlank()) {
            webView.loadUrl(customUrl)
        } else {
            // Load high-performance bundled offline HTML5/JS app directly
            webView.loadUrl("file:///android_asset/index.html")
        }
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        webView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}
