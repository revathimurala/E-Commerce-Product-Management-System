package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC delete example: deletes a product by id from products table.
 * Change 'idToDelete' to a real id that exists in the table.
 */
public class JDBCDelete {
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    private static final String URL = getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
    private static final String USER = getEnvOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("MYSQL_PASSWORD", "password");

    public static void main(String[] args) {
        int idToDelete = 1; // change as needed
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idToDelete);
            int rows = ps.executeUpdate();
            System.out.println("Deleted rows: " + rows);
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
