package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple JDBC SELECT example: lists rows from the products table.
 */
public class JDBCSelect {
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    private static final String URL = getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
    private static final String USER = getEnvOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("MYSQL_PASSWORD", "password");

    public static void main(String[] args) {
        String sql = "SELECT id, name, price, created_at FROM products ORDER BY id DESC LIMIT 100";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Products:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String created = rs.getString("created_at");
                System.out.printf("  id=%d name=%s price=%.2f created=%s%n", id, name, price, created);
            }

        } catch (SQLException e) {
            System.out.println("Select failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
