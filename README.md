# Evolutions 💜

An Android application designed to help a 44-year-old transgender woman incrementally become physically stronger, faster, and build better stamina — while also growing mentally across multiple knowledge domains and becoming more conscious of recovery nutrition.

## About

The app is built for a user with a specific health profile:
- ~195 lbs, sedentary background (Engineering Manager, Cybersecurity Zero Trust)
- ~7 years without exercise
- Injuries: both rotator cuffs, metal plate in left clavicle, slightly torn MCL (right knee), arthritis
- Health conditions: Crohn's Disease, aversion to fibrous green foods

Every workout, nutrition recommendation, and progression plan is tailored to these constraints.

## Features

### 🏠 Home Dashboard
- Daily rotating motivational message (7 affirmations)
- Today's workout preview
- Crohn's-friendly daily nutrition tip
- Daily knowledge challenge
- Quick stats: current week, workouts completed, streak

### 💪 Workout Plans (3 Phases)
All exercises include injury-specific modifications:
- **Phase 1 – Foundation (Weeks 1–4):** Gentle reactivation — wall push-ups, gentle walks, bird dogs, glute bridges, resistance band pull-aparts
- **Phase 2 – Building (Weeks 5–12):** Gradual intensity increase — seated rows, Pallof press, partial wall sits, hip abduction
- **Phase 3 – Advancing (Weeks 13+):** Progressive challenges — walk/jog intervals, incline push-ups, band deadlifts

Injury considerations enforced throughout:
- No overhead pressing or behind-the-neck movements (rotator cuffs + clavicle plate)
- No deep squats or high-impact jumping (MCL)
- Joint-friendly warm-ups for arthritis

### 🥗 Nutrition Guide
18 food items filtered by category (Protein, Recovery, Anti-Inflammatory, Fat, Carb, Avoid):
- Crohn's-friendly, low-fiber options prominently labeled
- Anti-inflammatory foods for arthritis and injury recovery (salmon, turmeric, ginger, bone broth)
- Clear "Avoid" section for Crohn's flare triggers
- Protein timing guidance for muscle building

### 📈 Progress Tracking
- Phase journey indicator
- Strength / Stamina / Wellbeing score bars
- Workout logger
- 8 milestone badges (First Workout, One Week Strong, etc.)
- 5 knowledge domains tracked: Cybersecurity, Exercise Science, Nutrition, Mind-Body, Trans Health

## Tech Stack
- **Language:** Kotlin
- **Architecture:** Single Activity + Navigation Component + ViewBinding + ViewModel/LiveData
- **UI:** Material Design 3 + BottomNavigationView
- **Min SDK:** 26 (Android 8.0) | **Target SDK:** 34

---

## Local Development Setup

### Prerequisites

Before you can build or run the app, install the following on your computer:

#### 1. Java Development Kit (JDK) 17
The Android Gradle plugin 8.x requires **JDK 17**.

- **macOS (Homebrew):**
  ```bash
  brew install openjdk@17
  ```
- **Windows:** Download the installer from [Adoptium](https://adoptium.net/temurin/releases/?version=17) and run it.
- **Linux (Ubuntu/Debian):**
  ```bash
  sudo apt update && sudo apt install openjdk-17-jdk
  ```

Verify the install:
```bash
java -version   # should show openjdk 17.x.x
```

#### 2. Android Studio (recommended — includes everything else)
Android Studio bundles the Android SDK, platform tools, and ADB automatically.

1. Download **Android Studio Hedgehog (2023.1) or newer** from [developer.android.com/studio](https://developer.android.com/studio)
2. Run the installer and follow the setup wizard
3. In the **SDK Manager** (Android Studio → Settings → Languages & Frameworks → Android SDK), ensure the following are installed:
   - **Android SDK Platform 34** (API 34, Android 14)
   - **Android SDK Build-Tools 34.0.0**
   - **Android SDK Platform-Tools** (includes ADB)

> **Alternative — Command-line tools only (no Android Studio UI):**
> Download the [command-line tools](https://developer.android.com/studio#command-tools) and set `ANDROID_HOME` to your SDK directory.

#### 3. Git
Used to clone the repository.
- **macOS:** `brew install git` or install Xcode Command Line Tools (`xcode-select --install`)
- **Windows:** Download from [git-scm.com](https://git-scm.com/download/win)
- **Linux:** `sudo apt install git`

---

### Clone and Build Locally

```bash
# 1. Clone the repository
git clone https://github.com/mmarti8895/evolutions.git
cd evolutions

# 2. (macOS/Linux) Make the Gradle wrapper executable
chmod +x gradlew

# 3. Build a debug APK
./gradlew assembleDebug          # macOS / Linux
# .\gradlew.bat assembleDebug    # Windows (PowerShell)
```

The debug APK will be generated at:
```
app/build/outputs/apk/debug/app-debug.apk
```

---

## Installing on Your Android Device

### Option A — USB Cable (Recommended for first install)

This method uses **ADB (Android Debug Bridge)**, which is included with Android Studio's Platform Tools.

#### Step 1 — Enable Developer Options on your phone
1. Open **Settings** → **About phone**
2. Tap **Build number** seven times in a row
3. You'll see "You are now a developer!" ✅
4. Go back to **Settings** → **System** → **Developer options** (location varies by phone/Android version)
5. Enable **USB debugging**

#### Step 2 — Connect your phone and authorize it
1. Plug your phone into your computer with a USB cable
2. On the phone, tap **Allow** when prompted *"Allow USB debugging?"*
3. Verify the connection:
   ```bash
   adb devices
   ```
   You should see your device listed, e.g.:
   ```
   List of devices attached
   R3CN90XXXXX    device
   ```

#### Step 3 — Install the APK
```bash
# Build + install in one command:
./gradlew installDebug

# — OR — install a pre-built APK directly:
adb install app/build/outputs/apk/debug/app-debug.apk
```

The **Evolutions** app icon will appear in your app drawer immediately.

---

### Option B — Android Studio (easiest if you have it installed)

1. Open Android Studio and choose **Open** → select the cloned `evolutions` folder
2. Let Gradle sync finish (first run downloads ~500 MB of dependencies — be patient)
3. Connect your phone via USB with USB debugging enabled (see Option A, Steps 1–2)
4. In the toolbar, select your device from the device drop-down
5. Click the green **▶ Run** button (or press `Shift+F10`)

Android Studio will build, install, and launch the app automatically.

---

### Option C — Emulator (no physical device needed)

1. In Android Studio, open **Device Manager** (the phone icon in the right toolbar)
2. Click **Create Device**
3. Choose a phone profile (e.g., **Pixel 7**) → click **Next**
4. Select a system image — download **API 34 (Android 14)** if not already installed → click **Next** → **Finish**
5. Click the **▶** button next to your new virtual device to start it
6. Run the app via the **▶ Run** button in the toolbar — Android Studio will deploy to the emulator

---

### Option D — Manual APK Sideload (share the APK file directly)

If you want to share the app with someone without them needing a development environment:

1. Build the APK:
   ```bash
   ./gradlew assembleDebug
   ```
2. Send `app/build/outputs/apk/debug/app-debug.apk` to the target device (via email, Google Drive, a USB file transfer, etc.)
3. On the Android device:
   - Open **Settings** → **Apps** → **Special app access** → **Install unknown apps**
   - Grant permission to your file manager or browser
   - Tap the APK file to install it

> ⚠️ **Note:** The debug APK is signed with a debug key and is fine for personal use. For sharing more broadly, build a release APK and sign it with your own keystore.

---

## Developing with VS Code (Alternative to Android Studio)

Android Studio is **not required**. You can use **Visual Studio Code** as your editor. VS Code won't give you a visual XML layout editor or a one-click emulator launcher, but everything needed to write code, build, and deploy to a real device (or a command-line emulator) works perfectly.

### What VS Code can and cannot do for Android development

| Capability | Android Studio | VS Code |
|---|---|---|
| Kotlin syntax highlighting & code completion | ✅ Full IntelliJ engine | ✅ Via extension (good, not identical) |
| Gradle build / run tasks | ✅ Built-in | ✅ Via Gradle extension or terminal |
| Deploy to physical device | ✅ One-click | ✅ `./gradlew installDebug` in terminal |
| Visual XML layout editor | ✅ | ❌ Not available |
| AVD (emulator) manager UI | ✅ Built-in | ❌ Use `avdmanager` CLI (see below) |
| Logcat viewer | ✅ Built-in | ⚠️ Via `adb logcat` in terminal or extension |
| Android SDK bundled | ✅ | ❌ Must install separately |

---

### Step 1 — Install the Android SDK (standalone, without Android Studio)

Because VS Code does not bundle the Android SDK, you need to install it manually.

1. Go to [developer.android.com/studio#command-tools](https://developer.android.com/studio#command-tools) and download the **Command-line tools only** package for your OS.
2. Unzip the download. Move the contents to a permanent location — for example:
   - **macOS/Linux:** `~/android-sdk/cmdline-tools/latest/`
   - **Windows:** `C:\android-sdk\cmdline-tools\latest\`
3. Set environment variables (add these to your shell profile — `~/.zshrc`, `~/.bashrc`, or Windows System Environment Variables):
   ```bash
   export ANDROID_HOME=$HOME/android-sdk
   export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
   export PATH=$PATH:$ANDROID_HOME/platform-tools
   export PATH=$PATH:$ANDROID_HOME/emulator
   ```
4. Reload your shell (`source ~/.zshrc` etc.) and then install the required SDK components:
   ```bash
   sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0" "emulator"
   sdkmanager --licenses   # accept all licenses
   ```

Verify ADB is available:
```bash
adb version
```

---

### Step 2 — Install VS Code extensions

Open VS Code, press `Ctrl+Shift+X` (or `Cmd+Shift+X` on macOS) to open the Extensions panel, and install:

| Extension | Publisher | Purpose |
|---|---|---|
| **Kotlin** | fwcd | Syntax highlighting, code navigation, basic IntelliSense for Kotlin |
| **Extension Pack for Java** | Microsoft | Java language server required by the Kotlin extension |
| **Gradle for Java** | Microsoft | Run Gradle tasks from the sidebar without typing commands |

> **Optional but useful:**
> - **Android iOS Emulator** (DiemasMichiels) — launch AVDs from the VS Code status bar
> - **Todo Tree** — highlights TODO/FIXME comments across the codebase

---

### Step 3 — Open and build the project

```bash
# Clone (if you haven't already)
git clone https://github.com/mmarti8895/evolutions.git
cd evolutions

# macOS/Linux — make Gradle wrapper executable
chmod +x gradlew

# Open in VS Code
code .
```

Once VS Code opens, the **Gradle for Java** extension will detect the project automatically. You can either:

- Use the **Gradle sidebar** (elephant icon on the left): expand `evolutions → app → build → Tasks → build`, then double-click **assembleDebug**
- Or run it directly in the **VS Code integrated terminal** (`Ctrl+\`` to open):
  ```bash
  ./gradlew assembleDebug          # macOS / Linux
  .\gradlew.bat assembleDebug      # Windows
  ```

The debug APK is output to `app/build/outputs/apk/debug/app-debug.apk`.

---

### Step 4 — Deploy to a physical Android device from VS Code

Enable USB debugging on your phone (see [Option A — USB Cable](#option-a--usb-cable-recommended-for-first-install) above), then from the VS Code integrated terminal:

```bash
# Build and install in one step
./gradlew installDebug

# — OR — install an already-built APK
adb install app/build/outputs/apk/debug/app-debug.apk

# Stream logs while the app is running
adb logcat -s "Evolutions"
```

---

### Step 5 — Run on an emulator from VS Code (command-line AVD)

Since VS Code has no built-in AVD manager, create and start virtual devices using the command-line tools installed in Step 1.

#### Create a virtual device (one-time setup)
```bash
# List available system images
sdkmanager --list | grep "system-images;android-34"

# Download a system image (Google APIs x86_64 is fastest on modern hardware)
sdkmanager "system-images;android-34;google_apis;x86_64"

# Create an AVD named "Pixel7"
avdmanager create avd -n Pixel7 -k "system-images;android-34;google_apis;x86_64" -d "pixel_7"
```

#### Start the emulator
```bash
emulator -avd Pixel7
```

Leave that terminal running. In a second terminal, deploy the app:
```bash
./gradlew installDebug
```

The app will install and appear in the emulator's app drawer.

#### List existing AVDs
```bash
avdmanager list avd
```

---

## Troubleshooting

| Problem | Fix |
|---|---|
| `JAVA_HOME` not set / wrong JDK | Set `JAVA_HOME` to your JDK 17 directory or configure it in Android Studio → Settings → Build → Gradle |
| `adb: command not found` | Add `$ANDROID_HOME/platform-tools` to your `PATH` |
| Device not listed by `adb devices` | Try a different USB cable, switch USB mode to "File Transfer" on the phone, and re-authorize debugging |
| Gradle sync fails on first open | Check your internet connection — Gradle downloads ~500 MB of Android SDK dependencies on the first build |
| App not installing: INSTALL_FAILED_UPDATE_INCOMPATIBLE | Uninstall any previous version of the app on the device first |
| `chmod +x gradlew` fails on Windows | Use `.\gradlew.bat` instead of `./gradlew` |
| VS Code: Kotlin extension shows no IntelliSense | Ensure **Extension Pack for Java** is also installed; reload VS Code after install |
| VS Code: Gradle tasks panel is empty | Open the project folder directly (`code .` from the repo root), not a parent folder |
| `sdkmanager: command not found` | Confirm `$ANDROID_HOME/cmdline-tools/latest/bin` is on your `PATH` and the tools were unzipped to the `latest/` subfolder |
| Emulator won't start (HAXM/WHPX error on Windows) | Enable hardware virtualization in your BIOS, or use an ARM system image instead of x86_64 |
| `emulator: command not found` | Add `$ANDROID_HOME/emulator` to your `PATH` |

---

## Philosophy

Progress over perfection. Every single step forward — no matter how small — is a victory.

