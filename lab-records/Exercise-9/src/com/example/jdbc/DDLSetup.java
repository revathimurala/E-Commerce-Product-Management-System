package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DDL helper: creates the `product` table used by the main project and copies
 * rows from the demo `products` table (if present).
 */
public class DDLSetup {
    private static String getEnvOrDefault(String name, String def) {
        String v = System.getenv(name);
        return (v == null || v.isEmpty()) ? def : v;
    }

    private static final String URL = getEnvOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce_demo");
    private static final String USER = getEnvOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = getEnvOrDefault("MYSQL_PASSWORD", "password");

    public static void main(String[] args) {
        String create = "CREATE TABLE IF NOT EXISTS product (" +
                "id INT NOT NULL PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "price DECIMAL(10,2) NOT NULL DEFAULT 0.00, " +
                "stock INT NOT NULL DEFAULT 0) ENGINE=InnoDB";

        String copy = "INSERT INTO product (id,name,price,stock) " +
                "SELECT id, name, price, 0 FROM products " +
                "ON DUPLICATE KEY UPDATE name=VALUES(name), price=VALUES(price)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = conn.createStatement()) {
            st.executeUpdate(create);
            try {
                int copied = st.executeUpdate(copy);
                System.out.println("Copied rows (products->product): " + copied);
            } catch (SQLException e) {
                System.out.println("Note: could not copy from products table (it may not exist): " + e.getMessage());
            }
            System.out.println("DDL setup finished.");
        } catch (SQLException e) {
            System.out.println("DDL setup failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
