Lab Report — Exercises 8 & 9

Student: ____________________
Instructor: Pradeep Sir
Date: _______________________

Summary
-------
This repository contains simple, runnable examples for:
- Exercise-8: using user-defined Java packages, a JavaFX FXML-only UI, and a JavaFX Tip Calculator app.
- Exercise-9: JDBC connect, insert and delete examples using MySQL Connector/J.

Files created
-------------
- Exercise-8/
  - UserPackageDemo/src/com/example/mypack/Greeting.java
  - UserPackageDemo/src/com/example/app/Main.java
  - JavaFX_NoCode/LabelAndImage.fxml
  - TipCalculator/src/com/example/tip/TipCalculator.java
- Exercise-9/
  - src/com/example/jdbc/JDBCConnect.java
  - src/com/example/jdbc/JDBCInsert.java
  - src/com/example/jdbc/JDBCDelete.java
- LabReport.md (this file)

How to run and expected outputs (short)
-------------------------------------
1) User-defined package demo
- Compile:
  javac -d lab-records\\out lab-records\\Exercise-8\\UserPackageDemo\\src\\com\\example\\mypack\\Greeting.java lab-records\\Exercise-8\\UserPackageDemo\\src\\com\\example\\app\\Main.java
- Run:
  java -cp lab-records\\out com.example.app.Main
- Expected output:
  Hello, Student! Welcome to Java packages.

2) JavaFX FXML-only UI
- Open `lab-records/Exercise-8/JavaFX_NoCode/LabelAndImage.fxml` with Scene Builder (optional) or load it from a small JavaFX launcher.
- No code required to describe the UI; it shows a label and an image.
- Placeholder for screenshot: [insert screenshot here]

3) JavaFX Tip Calculator
- Requires JavaFX SDK. Download from https://openjfx.io/, extract, and point module-path to the `lib` folder.
- Compile and run as instructed in the Exercise-8 README.
- Expected behavior: user enters bill and tip percentage, clicks Calculate, and the app shows Tip and Total.
- Placeholder for screenshot: [insert screenshot here]

4) JDBC connect / insert / delete
- Create the DB and table in MySQL (run in your MySQL client):
  CREATE DATABASE IF NOT EXISTS ecommerce_demo;
  USE ecommerce_demo;
  CREATE TABLE IF NOT EXISTS products (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), price DOUBLE);
- Set environment variables (PowerShell example):
  $env:MYSQL_URL = "jdbc:mysql://localhost:3306/ecommerce_demo"
  $env:MYSQL_USER = "root"
  $env:MYSQL_PASSWORD = "yourpassword"
- Compile:
  javac -cp ..\\mysql-connector-j-9.5.0\\mysql-connector-j-9.5.0.jar -d lab-records\\out lab-records\\Exercise-9\\src\\com\\example\\jdbc\\JDBCConnect.java
- Run connect:
  java -cp "lab-records\\out;..\\mysql-connector-j-9.5.0\\mysql-connector-j-9.5.0.jar" com.example.jdbc.JDBCConnect
- Expected output (connect):
  Trying to connect to the database...
  URL: jdbc:mysql://localhost:3306/ecommerce_demo
  User: root
  Connected successfully! Connection class: <driver-class>

- Run insert:
  java -cp "lab-records\\out;..\\mysql-connector-j-9.5.0\\mysql-connector-j-9.5.0.jar" com.example.jdbc.JDBCInsert
  Expected: Inserted rows: 1

- Run delete (change id in source if necessary):
  java -cp "lab-records\\out;..\\mysql-connector-j-9.5.0\\mysql-connector-j-9.5.0.jar" com.example.jdbc.JDBCDelete
  Expected: Deleted rows: 1

Notes for submission
--------------------
- Attach screenshots in the placeholders showing the app window (Tip Calculator and FXML UI) and console output for JDBC run.
- If MySQL is not available, you can show compilation output and explain how to run the JDBC steps.

Acknowledgements
----------------
Sample demos provided by Pradeep Sir (https://github.com/pradeepjuluri143)


