package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Simple JDBC connection example.
 * Edit the URL, user, and password constants below to match your database.
 */
public class JDBCConnect {
    // Read credentials from environment variables, with sensible defaults.
    // You can also pass URL, USER and PASSWORD as command-line arguments: java JDBCConnect <url> <user> <password>
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    public static void main(String[] args) {
        String url = (args.length >= 1 && args[0] != null && !args[0].isEmpty()) ? args[0]
                : getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
        String user = (args.length >= 2 && args[1] != null && !args[1].isEmpty()) ? args[1]
                : getEnvOrDefault("MYSQL_USER", "root");
        String password = (args.length >= 3 && args[2] != null && !args[2].isEmpty()) ? args[2]
                : getEnvOrDefault("MYSQL_PASSWORD", "password");

        System.out.println("Trying to connect to the database...");
        System.out.println("URL: " + url);
        System.out.println("User: " + user);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully! Connection class: " + conn.getClass().getName());
        } catch (SQLException e) {
            System.out.println("Failed to connect: " + e.getMessage());
            System.out.println("Tip: set MYSQL_URL, MYSQL_USER and MYSQL_PASSWORD environment variables or pass them as args.");
            e.printStackTrace();
        }
    }
}
