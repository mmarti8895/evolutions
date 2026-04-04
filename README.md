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

## Building

```bash
./gradlew assembleDebug
```

## Philosophy

Progress over perfection. Every single step forward — no matter how small — is a victory.

