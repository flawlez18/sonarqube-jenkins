package src.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root"; // Hardcoded password (deliberate vulnerability)
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
        }

        return connection;
    }
}