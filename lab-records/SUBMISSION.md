Final Submission — Exercises 8 & 9

This file is the single, ready-to-submit document that contains: a short lab report, exact commands used to compile/run the demos, places for screenshots, and instructions to restore/compile JavaFX examples locally.

1) What to include in your submission
- `LabReport.md` (already in repo) — short report and placeholders.
- `lab-records` folder (source code and FXML) — included in `lab-records.zip` at repo root.
- Screenshots for: (a) JavaFX Tip Calculator window, (b) FXML-only window, (c) JDBC console showing successful connect/insert/delete (or InMemoryDemo output if DB unavailable).
- Optional: `lab-records.zip` (already created at repo root).

2) Commands I ran (you can paste these into PowerShell on your machine from repo root)

Compile and run the simple user-package demo:

```powershell
# Compile
javac -d lab-records\out lab-records\Exercise-8\UserPackageDemo\src\com\example\mypack\Greeting.java lab-records\Exercise-8\UserPackageDemo\src\com\example\app\Main.java
# Run
java -cp lab-records\out com.example.app.Main
```

Compile and run non-JavaFX demos (InMemoryDemo) using the helper script:

```powershell
# Run the script (it compiles and runs the user-package demo + the in-memory demo)
powershell -ExecutionPolicy Bypass -File .\lab-records\run-demo.ps1
```

JDBC examples (requires MySQL server and connector JAR):

```powershell
# Adjust password as needed
$env:MYSQL_URL = "jdbc:mysql://localhost:3306/ecommerce_demo"
$env:MYSQL_USER = "root"
$env:MYSQL_PASSWORD = "your_password_here"

# Path to connector jar (project-root relative)
$jar = "..\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar"

# Compile
javac -cp $jar -d lab-records\out lab-records\Exercise-9\src\com\example\jdbc\JDBCConnect.java

# Run
java -cp "lab-records\out;$jar" com.example.jdbc.JDBCConnect
```

Notes: `JDBCInsert` and `JDBCDelete` are compiled/run in the same way. If you prefer not to run against MySQL, use `InMemoryDemo` which demonstrates the same insert/delete behavior without a DB.

3) Where the artifacts are
- `lab-records/` — all example source and FXML files.
- `lab-records/out/` — compiled classes (created when you compile locally or run the script).
- `lab-records.zip` — created at the project root (for submission).
- `mysql-connector-j-9.5.0/mysql-connector-j-9.5.0.jar` — runtime JDBC driver used by JDBC examples.
- Backup location for moved sources:
  - JavaFX sources moved to `third-party-backup/javafx-samples/` (TipCalculator.java, FXMLLauncher.java)
  - MySQL connector full sources (if ever moved) are under `third-party-backup/mysql-connector-src-9.5.0/` (if present)

4) How to restore and run the JavaFX examples locally

If you want to restore the JavaFX source files (Tip Calculator and launcher) into the repo active folders and compile/run them locally, do the following from the repo root.

Restore files (if necessary):

```powershell
# Move files back into lab-records
Move-Item -Path "third-party-backup\javafx-samples\TipCalculator.java" -Destination "lab-records\Exercise-8\TipCalculator\src\com\example\tip\TipCalculator.java"
Move-Item -Path "third-party-backup\javafx-samples\FXMLLauncher.java" -Destination "lab-records\Exercise-8\JavaFX_NoCode\FXMLLauncher.java"
```

Download JavaFX SDK (if you don't already have it) from https://openjfx.io/ and extract it. Suppose you extracted it to `C:\javafx-sdk-XX`.

Compile and run (replace the path with your actual JavaFX SDK path):

```powershell
$javafx = "C:\javafx-sdk-XX\lib\*"
# Compile
javac --module-path $javafx --add-modules javafx.controls,javafx.fxml -d lab-records\out lab-records\Exercise-8\TipCalculator\src\com\example\tip\TipCalculator.java
# Run
java --module-path $javafx --add-modules javafx.controls,javafx.fxml -cp lab-records\out com.example.tip.TipCalculator

# Run FXML-only launcher
javac --module-path $javafx --add-modules javafx.controls,javafx.fxml -d lab-records\out lab-records\Exercise-8\JavaFX_NoCode\FXMLLauncher.java
java --module-path $javafx --add-modules javafx.controls,javafx.fxml -cp lab-records\out com.example.fx.FXMLLauncher
```

5) Submission checklist (tick these before sending)
- [ ] Fill your name and date in `LabReport.md`.
- [ ] Add screenshots to `LabReport.md` placeholders (TipCalculator, FXML, JDBC/in-memory console output).
- [ ] Ensure `lab-records.zip` is present (I created it for you at repo root).
- [ ] Optionally include a short note saying which commands you ran locally and any deviations.

6) Contact / Troubleshooting notes
- If `javac` complains about JavaFX imports: ensure you used the `--module-path` and `--add-modules` options pointing to the JavaFX SDK `lib` folder.
- If JDBC connect fails: check the DB URL, username, password and that the MySQL server is running and reachable. Use the `InMemoryDemo` output if you can't connect to a DB.

---

If you want I can:
- produce a single PDF containing this submission file and `LabReport.md` (I can generate it and place it at repo root), or
- open a PR and attach the `lab-records.zip` to it for you.

Tell me which of those you want next (PDF generation, PR with attachments, or nothing — you're ready to submit).