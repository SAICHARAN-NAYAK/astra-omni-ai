# ASTRA OMNI AI Android App // Native Hybrid Edition

Native Android Studio application for **ASTRA OMNI AI** (Gemini 2.0 Pro + ChatGPT-6 Omni + Project Astra Live AR).

---

## How to Open in Android Studio

1. Open **Android Studio**, click **File** &rarr; **Open**, and select this folder:
   `.../astra-omni-ai/android_studio_app`
2. Allow Android Studio to sync Gradle dependencies.
3. Select your device or emulator from the device dropdown.
4. Click **Run** (or press `Shift + F10`).

---

## Project Structure

```
android_studio_app/
├── build.gradle.kts                 # Root project build configuration
├── settings.gradle.kts               # Gradle settings (AstraOmniAI)
├── local.properties                 # Points to local Android SDK
├── app/
│   ├── build.gradle.kts             # App dependencies (com.astra.omni, WebKit, Material)
│   └── src/main/
│       ├── AndroidManifest.xml      # Camera, Record Audio, Internet, Haptic permissions
│       ├── java/com/astra/omni/
│       │   ├── MainActivity.kt      # Hardware-accelerated WebView & back navigation
│       │   └── WebAppInterface.kt   # Native AndroidBridge (haptics, toasts, device info)
│       ├── assets/                  # Bundled Astra Omni AI web application
│       │   ├── index.html           # Gemini, ChatGPT-6, and Project Astra UI
│       │   ├── styles.css           # Modern classic design system
│       │   └── app.js               # Client controller with local neural simulation & vault
│       └── res/                     # Android layouts, colors, Theme.AstraOmni, icons
```

---

## Key Features

1. **Hardware-Accelerated Multimodal Core**:
   - Bundles the complete ASTRA OMNI frontend into `app/src/main/assets/`.
   - Native WebKit configuration with camera & microphone permission bridges for Project Astra Live AR viewfinder.

2. **Autonomous Offline AI Engine**:
   - Operates 100% locally with zero external network requirements.
   - Built-in Autonomous Neural Engine computes prompt responses directly in the local runtime.

3. **Native Bridge (`AndroidBridge`)**:
   - `AndroidBridge.showToast(message)`: Native Android system toasts.
   - `AndroidBridge.triggerHaptic(severity)`: Physical device haptic vibrations on model switches, OTP verification, and actions.
   - `AndroidBridge.getDeviceInfo()`: Hardware telemetry and network connection state.

4. **Building APK from CLI**:
   ```bash
   ./gradlew assembleDebug
   ```
   Output APK will be generated at `app/build/outputs/apk/debug/app-debug.apk`.
