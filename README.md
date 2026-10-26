# GameHub

A pocket arcade of **26 retro mini-games** in one offline Android app. Create player profiles, earn points, unlock upgrades in the shop, collect achievements and track your stats.

No ads. No tracking. No permissions. No internet connection needed.

## Features

- 26 arcade, puzzle and strategy games, including Snake, Pong, Tetris, 2048, Minesweeper, Breakout, Asteroids, Space Invaders, Connect 4, Blackjack, Hangman and Tower Defense
- Multiple player profiles, each with its own scores and progress
- Points, a shop, achievements and a stats screen
- Retro pixel look with optional scanlines, sound, animations and on-screen touch controls
- Works fully offline; all data stays on your device

## Privacy

GameHub requests no Android permissions and blocks all network loads inside its WebView. Profiles, scores and settings are stored locally on your device only, and uninstalling the app removes them.

## How it works

The whole game is one HTML/JavaScript file, `app/src/main/assets/index.html`. A small Android app (`MainActivity.java`) shows it in a WebView. That means you can also open `index.html` in any desktop browser to play or to work on the game.

## Build

Requirements: Android Studio (recent version) or Gradle, plus JDK 17.

1. Clone the repository:

   ```
   git clone https://github.com/andai256/gamehub.git
   ```

2. Open the folder in Android Studio and click **Run**, or build from a terminal:

   ```
   gradle :app:assembleDebug
   ```

The APK appears under `app/build/outputs/apk/`.

## Project structure

```
app/src/main/assets/index.html   the game
app/src/main/assets/fonts/       bundled fonts and their licenses
app/src/main/java/.../MainActivity.java   WebView wrapper
fastlane/metadata/android/       store listing text and icon (F-Droid)
```

## Fonts

Bundled under the SIL Open Font License 1.1: **Press Start 2P** and **Share Tech Mono**. See `app/src/main/assets/fonts/FONTS.md` and the OFL files in that folder.

## License

The source code is released under the MIT License, see [LICENSE](LICENSE).
