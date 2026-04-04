# PvotCalculator

## Project
Minimalist Android calculator app (iOS-inspired design) built with Jetpack Compose.

## Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose + Material 3
- **Architecture**: ViewModel + Composable UI (no Hilt, no Room)
- **Min SDK**: 30 | **Target/Compile SDK**: 36
- **Font**: Sora (Thin, Light, Regular, Medium)

## Git Rules
- **NEVER push directly to `main`**. Always work on a feature/fix branch and open a PR.
- Branch naming: `fix/<topic>`, `feat/<topic>`
- Keep commits small and scoped — do not batch unrelated changes in one commit.
- PR must reference the issue it closes (`Closes #N` in body).

## Build
```
./gradlew assembleDebug
./gradlew assembleRelease
```
Release artifact name: `PvotCalculator-v<versionName>.apk` (set via `archivesName`).
Versioning is semantic — bump in root `build.gradle.kts` (`versionMajor`, `versionMinor`, `versionPatch`).

## Architecture Overview
```
MainActivity
└── CalculatorScreen          # orientation-aware root composable
    ├── CalculatorDisplay     # private — expression + value, portrait & landscape variants
    └── CalculatorKeypad      # public — routes to PortraitKeypadLayout or LandscapeKeypadLayout
        ├── PortraitKeypadLayout   # 4-col × 5-row circular buttons
        └── LandscapeKeypadLayout  # 5-col × 4-row pill buttons (BoxWithConstraints sizing)
CalculatorViewModel           # state: display, expression, operand1, operator
```

## Orientation
- Portrait: circular buttons (4 × 5), display with `weight(1f)` above keypad.
- Landscape: pill buttons (5 × 4), compact 2-line display (expression + value, fixed height) above keypad. Sized via `BoxWithConstraints` — no hardcoded `screenWidthDp`.
- `screenOrientation` is NOT locked in the manifest.

## Key Conventions
- Button sizing must use `BoxWithConstraints`, not `LocalConfiguration.current.screenWidthDp`.
- `WideCalcButton` (portrait "0") width = `buttonSize × 2 + spacing` — not `fillMaxWidth(0.5f)`.
- No portrait code should be touched when fixing landscape, and vice versa.
- Do not add icon dependencies for symbols — use Unicode (e.g. `"⌫"`).
