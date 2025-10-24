Exercise 8 — Java packages and JavaFX (simple, step-by-step)

Goal (kid-friendly):
- Learn how to create and use your own Java package.
- Build a JavaFX GUI without writing Java code (use FXML).
- Build a small Tip Calculator app in JavaFX and respond to button clicks.

What to have ready:
- JDK 17 or later installed.
- JavaFX SDK downloaded and extracted (version matching your JDK). See https://openjfx.io/.
- Optional: an editor (VS Code, IntelliJ) and Scene Builder to edit FXML visually.

Contents in this folder:
- UserPackageDemo: simple example that creates a package and uses it.
- JavaFX_NoCode: an FXML file that shows a Label and an ImageView (no Java code is required to define UI).
- TipCalculator: a small JavaFX app (source code) that calculates tip and responds to user input.

Quick notes for Windows PowerShell (copy/paste):
- Compile plain Java (no JavaFX):
  javac -d out src\com\example\mypack\Greeting.java src\com\example\app\Main.java
  java -cp out com.example.app.Main

- Compile and run JavaFX apps (replace <path-to-javafx-lib> with your javafx lib path):
  $javafx = "C:\path\to\javafx-sdk-XX\lib\*"
  javac --module-path $javafx --add-modules javafx.controls,javafx.fxml -d out TipCalculator\src\com\example\tip\TipCalculator.java
  java --module-path $javafx --add-modules javafx.controls,javafx.fxml -cp out com.example.tip.TipCalculator

If you need help installing Java or JavaFX, tell me which OS and I will provide exact steps.
