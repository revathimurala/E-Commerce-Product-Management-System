package main.java.com.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Allow overriding via environment variables for easier local dev and CI.
    private static final String URL = System.getenv().getOrDefault("MYSQL_URL", "jdbc:mysql://localhost:3306/ecommerce");
    private static final String USER = System.getenv().getOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("MYSQL_PASSWORD", "root");

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            String hint = String.format("Failed to connect to database at %s as user '%s'.\n" +
                    "Check that MySQL is running, the database exists, and credentials are correct.\n" +
                    "You can override settings with env vars MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD.\n" +
                    "Original error: %s",
                    URL, USER, e.getMessage());
            throw new SQLException(hint, e);
        }
    }
}
