package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC insert example: adds a product to products table.
 */
public class JDBCInsert {
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    private static final String URL = getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
    private static final String USER = getEnvOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("MYSQL_PASSWORD", "password");

    public static void main(String[] args) {
        String name = "Sample Product";
        double price = 49.99;
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            int rows = ps.executeUpdate();
            System.out.println("Inserted rows: " + rows);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
