# HabitFocus — v1 (Habit Tracker + To-Do), built entirely from your phone

No computer needed. GitHub builds the app for you in the cloud (free);
you just create the files by pasting code through your phone's browser.

## Step 1 — Create a free GitHub account
Go to github.com in your phone browser, sign up (if you don't have an account).

## Step 2 — Create a new repository
- Tap the "+" icon → "New repository"
- Name it: `habitfocus`
- Set it to Public (Actions build minutes are free/unlimited on public repos)
- Check "Add a README file"
- Tap "Create repository"

## Step 3 — Create each file
Extract the zip you downloaded using your phone's file manager (most phones
can open .zip files natively — tap it, "Extract"). Then open each file inside
with any text viewer app to see its content.

For EACH file listed below:
1. In your GitHub repo, tap "Add file" → "Create new file"
2. In the file name box, type the FULL path exactly as shown (this auto-creates
   the folders for you) — e.g. `app/src/main/java/com/example/habitfocus/MainActivity.kt`
3. Open the matching file from the extracted zip, select all, copy
4. Paste into GitHub's content box
5. Scroll down, tap "Commit changes"
6. Repeat for the next file

Files to create, in this order:
```
settings.gradle.kts
build.gradle.kts
gradle.properties
app/build.gradle.kts
app/proguard-rules.pro
app/src/main/AndroidManifest.xml
app/src/main/res/values/strings.xml
app/src/main/res/values/colors.xml
app/src/main/res/values/themes.xml
app/src/main/res/drawable/ic_launcher_background.xml
app/src/main/res/drawable/ic_launcher_foreground.xml
app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml
app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml
app/src/main/java/com/example/habitfocus/MainActivity.kt
app/src/main/java/com/example/habitfocus/data/Habit.kt
app/src/main/java/com/example/habitfocus/data/Todo.kt
app/src/main/java/com/example/habitfocus/data/HabitDao.kt
app/src/main/java/com/example/habitfocus/data/TodoDao.kt
app/src/main/java/com/example/habitfocus/data/AppDatabase.kt
app/src/main/java/com/example/habitfocus/viewmodel/HabitViewModel.kt
app/src/main/java/com/example/habitfocus/viewmodel/TodoViewModel.kt
app/src/main/java/com/example/habitfocus/ui/HabitScreen.kt
app/src/main/java/com/example/habitfocus/ui/TodoScreen.kt
app/src/main/java/com/example/habitfocus/ui/theme/Color.kt
app/src/main/java/com/example/habitfocus/ui/theme/Type.kt
app/src/main/java/com/example/habitfocus/ui/theme/Theme.kt
.github/workflows/build.yml
```

## Step 4 — Let it build
The last file you added (`.github/workflows/build.yml`) automatically triggers
a build the moment you commit it. In your repo:
- Tap the "Actions" tab
- You'll see a run in progress ("Build APK") — tap it, wait ~3-5 minutes
- When it finishes (green check), scroll down to "Artifacts"
- Tap "habitfocus-debug-apk" to download it (it's a zip containing the APK)

## Step 5 — Install on your phone
- Extract that downloaded zip → you'll get `app-debug.apk`
- Tap the APK file to install
- Your phone will ask to "allow installs from this source" the first time —
  allow it, then install
- Open the app — dark theme, custom flame icon, bold headline type,
  Habits and To-Do tabs, ready to use

## The design, briefly
- Colors: ultraviolet (#7C5CFF) + amber (#FFB300) + coral (#FF5C7A) on a deep
  plum-black background — bold and energetic without the generic
  "black background, one neon accent" look
- Type: chunky black-weight headlines paired with clean body text for contrast
- Icon: an abstract two-tone flame (violet outer, amber core) tying into the
  streak feature
- Dark mode by default, with a matching light mode included too

## If a build fails
Tap the failed run in the Actions tab → tap the red ✗ step → read the error.
Most common cause: a typo in a file path or a missed line while pasting.
Come back and paste me the error text — I'll tell you exactly what to fix.

## What's next (v2)
Charts, notifications, the focus-mode app blocker, widget — we add these
one at a time on top of this working base, same file-by-file process.
