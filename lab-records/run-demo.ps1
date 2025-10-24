# run-demo.ps1
# Compile and run quick demos for the lab-records folder (non-JavaFX)
# Usage: Open PowerShell in repo root and run: .\lab-records\run-demo.ps1

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$repoRoot = Split-Path -Parent $scriptDir
$out = Join-Path $scriptDir "out"

Write-Host "Demo script running. Script dir: "$scriptDir
Write-Host "Repo root: "$repoRoot

# Create output dir
if (!(Test-Path $out)) { New-Item -ItemType Directory -Path $out | Out-Null }

function run-and-check {
    param(
        [string]$exe,
        [Parameter(ValueFromRemainingArguments=$true)]
        $args
    )
    Write-Host "-> Running: $exe $($args -join ' ')"
    & $exe @args
    if ($LASTEXITCODE -ne 0) {
        Write-Error "$exe failed with exit code $LASTEXITCODE"
        exit $LASTEXITCODE
    }
}

Write-Host "\n1) Compile and run user-defined package demo"
$greeting = Join-Path $scriptDir "Exercise-8\UserPackageDemo\src\com\example\mypack\Greeting.java"
$main = Join-Path $scriptDir "Exercise-8\UserPackageDemo\src\com\example\app\Main.java"

run-and-check javac "-d" "$out" "$greeting" "$main"

Write-Host "Running user-package demo (expected: Hello, Student!... )"
run-and-check java "-cp" "$out" "com.example.app.Main"

Write-Host "\n2) Compile JDBC and In-memory demos"
$jc1 = Join-Path $scriptDir "Exercise-9\src\com\example\jdbc\JDBCConnect.java"
$jc2 = Join-Path $scriptDir "Exercise-9\src\com\example\jdbc\JDBCInsert.java"
$jc3 = Join-Path $scriptDir "Exercise-9\src\com\example\jdbc\JDBCDelete.java"
$jc4 = Join-Path $scriptDir "Exercise-9\src\com\example\jdbc\Product.java"
$jc5 = Join-Path $scriptDir "Exercise-9\src\com\example\jdbc\InMemoryDemo.java"
$files = @($jc1, $jc2, $jc3, $jc4, $jc5)

# Compile (these use only java.sql and core JDK so no connector JAR is required to compile)
$javacArgs = @("-d", $out) + $files
Write-Host "Compiling: $($files -join ', ')"
& javac @javacArgs
if ($LASTEXITCODE -ne 0) { Write-Error "Compilation failed"; exit $LASTEXITCODE }

Write-Host "Running InMemoryDemo (insert/select/delete simulation)"
run-and-check java "-cp" "$out" "com.example.jdbc.InMemoryDemo"

Write-Host "\nDone. Quick notes:"
Write-Host "- The JavaFX examples (Tip Calculator, FXML) require JavaFX SDK on the module-path and are not run by this script."

$jar = Join-Path $repoRoot "mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar"
if (Test-Path $jar) {
    Write-Host "- Found MySQL JDBC jar at: $jar"
    Write-Host "  To run the JDBC examples with a MySQL server available, set environment variables and run the commands below:"
} else {
    Write-Host "- MySQL connector jar not found at: $jar"
    Write-Host "  If you want to run JDBC examples against a real DB, place the connector jar at that path or adjust the commands below."
}

Write-Host "PowerShell example to run JDBC with the connector jar (adjust password):"
Write-Host "$env:MYSQL_URL = 'jdbc:mysql://localhost:3306/ecommerce_demo'"
Write-Host "$env:MYSQL_USER = 'root'"
Write-Host "$env:MYSQL_PASSWORD = 'your_password_here'"
Write-Host "javac -cp $jar -d lab-records\\out lab-records\\Exercise-9\\src\\com\\example\\jdbc\\JDBCConnect.java"
Write-Host ('java -cp "lab-records\out;{0}" com.example.jdbc.JDBCConnect' -f $jar)

Write-Host "\nEnd of script."