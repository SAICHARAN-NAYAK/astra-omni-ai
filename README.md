# ASTRA OMNI // Gemini 2.0 + ChatGPT-6 + Project Astra All-In-One AI

> **100% Free, Safe, and Cryptographically Secure Autonomous Multimodal AI**  
> Combining Google Gemini 2.0 Pro multimodal synthesis, OpenAI ChatGPT-6 Omni deep reasoning, and Google Project Astra live spatial perception in a single unified, classic-modern platform.

---

## 🌟 Key Features

- **Google Gemini 2.0 Pro Mode**: Fast visual synthesis, dynamic artifacts, Google Search grounding, and code preview.
- **OpenAI ChatGPT-6 Omni Mode**: Multi-step recursive thinking process with expandable formal reasoning and interactive code sandbox.
- **Project Astra Live AR Subsystem**: Live camera vision, spatial object tracking HUD, and low-latency duplex voice interaction.
- **Real-World Authentication**:
  - Continue with Google (OAuth sign-in).
  - 6-Digit Email / Mobile Phone OTP verification with countdown timer.
  - One-click Guest Access mode.
- **Strict Privacy & Security**:
  - Client-side **Web Crypto AES-GCM 256-bit encrypted vault**.
  - Air-gapped offline privacy mode killswitch.
  - Strict threat guardrails against prompt injection and data exfiltration.
  - Anonymous identity profiles (**`User`** / **`Client`**) with zero personal data leakage.
- **Human-Friendly UI/UX**:
  - Classic modern sidebar with proportional icons.
  - Smooth spring modal entrance, staggered digit bounce, gentle error shake feedback, and real-time 3-dot AI thinking wave.
  - Interactive Canvas Sandbox for live HTML/JS/CSS code execution.

---

## 🚀 Quick Start (Local)

### Windows (One-Click)
Double-click `Launch_Astra_Omni.bat`. It starts a local zero-dependency web server and automatically opens `http://localhost:8090` in your browser.

### Cross-Platform (Command Line)
```bash
# Using Python
python -m http.server 8090

# Or using Node
npx serve .
```
Open [http://localhost:8090](http://localhost:8090) in your browser.

---

## 🌐 Live Web Deployment

### 1. GitHub Pages (Automated via Actions)
1. Push this repository to GitHub:
   ```bash
   git remote add origin https://github.com/<your-username>/astra-omni-ai.git
   git branch -M main
   git push -u origin main
   ```
2. In your repository on GitHub, go to **Settings** > **Pages**.
3. Under **Build and deployment** > **Source**, select **GitHub Actions**.
4. Your site will automatically go live at:
   `https://<your-username>.github.io/astra-omni-ai/`

### 2. Vercel (1-Click Instant Deploy)
Configured with [`vercel.json`](./vercel.json):
1. Sign in to [vercel.com](https://vercel.com) and click **Add New Project**.
2. Select this repository and click **Deploy**.

### 3. Netlify (Drag & Drop or Git)
Configured with [`netlify.toml`](./netlify.toml) including camera/microphone permissions policy:
- Drag and drop this folder onto [app.netlify.com/drop](https://app.netlify.com/drop), or
- Connect your GitHub repository.

---

## 📱 Mobile App (Android Studio)

A complete native Android Studio wrapper is included in [`android_studio_app/`](./android_studio_app):
1. Double-click `Open_In_Android_Studio.bat` or open `android_studio_app` in Android Studio.
2. Select **Build** > **Build Bundle(s) / APK(s)** > **Build APK(s)**.
3. Install the generated APK on your Android device. Camera, Microphone, and Audio permissions are pre-configured for live Project Astra AR interaction.

---

## 🔒 Security Architecture

- **Zero External Telemetry**: Session data, chat histories, and keys remain entirely inside your browser's local Web Crypto AES-GCM vault.
- **Air-Gap Capability**: Switch to offline simulation or localhost models (Ollama) with no outbound network traffic.
- **Guardrail Filters**: Automatically redacts credentials, private tokens, and script exploits.

---

## 📄 License
MIT License. Free to use, modify, and distribute.
