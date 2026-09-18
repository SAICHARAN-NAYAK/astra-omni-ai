# ASTRA OMNI // Gemini 2.0 + ChatGPT-6 + Project Astra All-In-One AI

[![Live Production Web App](https://img.shields.io/badge/Live%20App-GitHub%20Pages-success?style=for-the-badge&logo=github)](https://saicharan-nayak.github.io/astra-omni-ai/)
[![Download Android APK](https://img.shields.io/badge/Android%20APK-Download%20v2.4-blue?style=for-the-badge&logo=android)](https://github.com/SAICHARAN-NAYAK/astra-omni-ai/raw/main/releases/app-debug.apk)
[![Security Vault](https://img.shields.io/badge/Security-AES--GCM--256-green?style=for-the-badge&logo=shield)](https://saicharan-nayak.github.io/astra-omni-ai/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

> **100% Free, Safe, and Cryptographically Secure Autonomous Multimodal AI**  
> Combining Google Gemini 2.0 Pro multimodal synthesis, OpenAI ChatGPT-6 Omni deep reasoning, and Google Project Astra live spatial perception in a single unified, classic-modern platform.

---

## 🌐 Live Production Access

* **Official Live Web App:** [https://saicharan-nayak.github.io/astra-omni-ai/](https://saicharan-nayak.github.io/astra-omni-ai/)
* **Direct Android APK Download:** [`releases/app-debug.apk`](./releases/app-debug.apk) (Size: ~6.0 MB, includes full offline engine)
* **Google Play App Bundle (.aab):** [`releases/app-release.aab`](./releases/app-release.aab) (Size: ~4.2 MB, ready for Play Console)
* **Privacy Policy (Google Play Compliant):** [https://saicharan-nayak.github.io/astra-omni-ai/privacy-policy.html](https://saicharan-nayak.github.io/astra-omni-ai/privacy-policy.html)
* **Main Repository:** [https://github.com/SAICHARAN-NAYAK/astra-omni-ai](https://github.com/SAICHARAN-NAYAK/astra-omni-ai)

---

## 🌟 Key Features

### 1. Unified Tri-Model Intelligence
- **Google Gemini 2.0 Pro Multimodal**: Fast visual synthesis, dynamic artifacts, real-time Google Search grounding chips, and double-check fact verification.
- **OpenAI ChatGPT-6 Omni Deep Thought**: Recursive reasoning engine with expandable thought accordions and interactive code sandbox.
- **Project Astra Live AR Viewfinder**: Live camera perception, spatial object detection HUD, and low-latency duplex voice interaction.

### 2. Natural Authentication & Profile Customization
- **Google 1-Click Sign-In** as standard `User`.
- **6-Digit Email & Mobile OTP Verification** with auto-advancing input boxes, copy-paste support, and resend countdown.
- **Interactive Profile Customization**:
  - Customize Display Name, Email/Handle, and Bio status.
  - Choose from 8 custom avatar icons (`👤`, `🧑‍💻`, `🛡️`, `🚀`, `⚡`, `🤖`, `🌟`, `👑`) with instant live preview.
  - Select role specialty (`AI Researcher`, `Cybersecurity Analyst`, `Software Engineer`, `Creative Designer`, etc.).
- **Permanent Account & Profile Deletion (Danger Zone)**:
  - Cryptographically shreds local session tokens, wipes stored credentials, and reverts to clean Guest mode.

### 3. Bulletproof Security & Anti-Spam Defense
- **Zero Server-Side Billing Vulnerability**: Zero API keys are stored on server backends; queries run on a local offline neural engine or within the client's own browser memory. Spammers cannot drain cards or run up bills.
- **Sliding-Window Rate Limiter**: Automatically caps rapid requests at 5 queries per 10 seconds with a cooldown penalty.
- **Brute-Force OTP Lockout**: Locks out verification for 60 seconds after 3 failed attempts.
- **Client-Side AES-GCM (256-bit) Vault**: Cryptographically encrypts local storage records with custom passphrases.
- **Strict Guardrails**: Intercepts jailbreaks (`DAN mode`, `ignore instructions`), credential exfiltration, and XSS `<script>` injections.

### 4. Modern Classic Ergonomics & Animations
- Compact, proportional SVG icons without oversized elements.
- Fluid micro-animations for message entry, typing wave dots, and interactive canvas expansion.
- Right-hand collapsible **Code Canvas** with live code execution for HTML, CSS, JavaScript, and diagrams.

---

## 📱 Mobile App (Android Studio)

A complete native Android Studio wrapper is included in [`android_studio_app/`](./android_studio_app):
* Built with Kotlin, Jetpack Core, WebView, and Hardware Acceleration.
* Camera & Audio permissions configured for Project Astra Live AR.
* Pre-compiled APK ready at [`releases/app-debug.apk`](./releases/app-debug.apk).
* To rebuild locally:
  ```bash
  cd android_studio_app
  ./gradlew assembleDebug
  ```

---

## 🚀 Running Locally (Web)

### Windows (One-Click)
Double-click `Launch_Astra_Omni.bat`. It starts a local web server and opens `http://localhost:8090` in your browser.

### Cross-Platform Command Line
```bash
# Using Python
python -m http.server 8090

# Or using Node
npx serve .
```

---

## 📄 License
MIT License. Free to use, modify, and distribute.
