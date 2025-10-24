Running the JDBC demo using MySQL Workbench

This document explains how to set up the demo database using MySQL Workbench and how to run the Java JDBC examples that live in `lab-records/Exercise-9`.

Files added:
- `sql/setup_ecommerce_demo.sql` — SQL script you can paste into Workbench and execute to create the `ecommerce_demo` database, the `products` table and sample rows.

Steps
1. Open MySQL Workbench and connect to your MySQL server as a user with CREATE privileges (for example `root`).

2. Create the database and sample data
   - Open a new SQL tab (File → Open SQL Script...) and open `sql/setup_ecommerce_demo.sql`, or paste the file contents into a new tab.
   - Review the optional `CREATE USER / GRANT` block — uncomment if you want a dedicated user.
   - Execute the script (lightning bolt). Confirm there are no errors. You should see the `ecommerce_demo` database and a `products` table.

3. Construct the JDBC URL
   - Basic JDBC URL format for MySQL:

     jdbc:mysql://<host>:<port>/<databaseName>

   - Examples:
     - Local server with default port and the demo database:
       jdbc:mysql://localhost:3306/ecommerce_demo
     - If your server requires explicit timezone/SSL options, you can append query parameters, for example:
       jdbc:mysql://localhost:3306/ecommerce_demo?serverTimezone=UTC&useSSL=false

4. Run the Java JDBC examples (from a PowerShell terminal)
   - The Java examples expect the MySQL Connector/J driver JAR that is included in the repository at:
     `mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar`

   - Compile the examples and run the connection test. Replace `<DBNAME>` if you used a different name and replace credentials as appropriate.

```powershell
# Set environment variables for this PowerShell session
$env:MYSQL_URL = 'jdbc:mysql://localhost:3306/ecommerce_demo'
$env:MYSQL_USER = 'root'
$env:MYSQL_PASSWORD = 'Revathi_2007'

# Compile the Java sources (adjust the path to the repo as needed)
javac -cp 'c:\Users\revat\OneDrive\Documents\GitHub\E-Commerce-Product-Management-System\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar' -d lab-records\out lab-records\Exercise-9\src\com\example\jdbc\*.java

# Run the simple connection tester
java -cp 'lab-records\out;c:\Users\revat\OneDrive\Documents\GitHub\E-Commerce-Product-Management-System\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar' com.example.jdbc.JDBCConnect
```

5. Optional: run insert/delete examples

```powershell
# Insert a new product (args: name description price)
java -cp 'lab-records\out;c:\Users\revat\OneDrive\Documents\GitHub\E-Commerce-Product-Management-System\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar' com.example.jdbc.JDBCInsert "New Product" "Demo product" 12.50

# Delete by id (example deletes id=1)
java -cp 'lab-records\out;c:\Users\revat\OneDrive\Documents\GitHub\E-Commerce-Product-Management-System\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar' com.example.jdbc.JDBCDelete 1
```

Notes and troubleshooting
- If the connection fails with a 'Unknown database' error, double-check the database name in Workbench and the JDBC URL.
- If the connection fails with an 'Access denied' error, either correct the username/password or create/GRANT privileges for the desired user (the SQL script includes commented instructions).
- If you need to allow remote connections, ensure the MySQL server is listening on the interface you expect and the firewall allows the port.

If you'd like, I can also run the connect test from this environment — confirm the DB host (or use `localhost`), your username and password, and which database name to use.
