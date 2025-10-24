Exercise 9 — JDBC (kid-friendly step-by-step)

Goal:
- Learn how Java connects to a database using JDBC.
- Write simple programs to connect, insert data, and delete data.

Prerequisites:
- JDK 8+ installed.
- MySQL server running locally or remote with a user you can use (root or another user).
- The MySQL JDBC driver JAR (mysql-connector-j-9.5.0.jar) is available in the repository at the project root: mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar

Sample SQL to create a test database and table (run in MySQL):

CREATE DATABASE IF NOT EXISTS ecommerce_demo;
USE ecommerce_demo;

CREATE TABLE IF NOT EXISTS products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DOUBLE NOT NULL
);

How to compile and run (PowerShell):

# adjust the path to the connector jar if needed (from project root)
$jar = "..\..\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar"

# Compile the examples (creates class files under lab-records\out)
javac -cp $jar -d lab-records\out lab-records\Exercise-9\src\com\example\jdbc\JDBCConnect.java
javac -cp $jar -d lab-records\out lab-records\Exercise-9\src\com\example\jdbc\JDBCInsert.java
javac -cp $jar -d lab-records\out lab-records\Exercise-9\src\com\example\jdbc\JDBCDelete.java

# Run: the programs read credentials from environment variables by default.
# Set environment variables in PowerShell like below (temporary for this session):
$env:MYSQL_URL = "jdbc:mysql://localhost:3306/ecommerce_demo"
$env:MYSQL_USER = "root"
$env:MYSQL_PASSWORD = "your_password_here"

java -cp "lab-records\out;$jar" com.example.jdbc.JDBCConnect
java -cp "lab-records\out;$jar" com.example.jdbc.JDBCInsert
java -cp "lab-records\out;$jar" com.example.jdbc.JDBCDelete

Notes:
- The sample code uses defaults for the JDBC URL and credentials but will prefer environment variables if set.
- Alternatively you can pass URL, user and password as command-line arguments to `JDBCConnect`:
  `java -cp "lab-records\\out;$jar" com.example.jdbc.JDBCConnect jdbc:mysql://host:3306/dbname user password`

If you want, I can run a quick smoke compile for you here, or provide screenshots/instructions for your machine.