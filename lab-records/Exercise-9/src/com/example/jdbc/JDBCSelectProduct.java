package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Lists rows from the `product` table (singular) used by the main project.
 */
public class JDBCSelectProduct {
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    private static final String URL = getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
    private static final String USER = getEnvOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("MYSQL_PASSWORD", "password");

    public static void main(String[] args) {
    // Note: the `product` table (used by the main app) does not have a created_at column.
    String sql = "SELECT id, name, price, stock FROM product ORDER BY id DESC LIMIT 100";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Product table rows:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                System.out.printf("  id=%d name=%s price=%.2f stock=%d%n", id, name, price, stock);
            }

        } catch (SQLException e) {
            System.out.println("Select from product failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
