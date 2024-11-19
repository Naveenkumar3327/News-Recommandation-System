package NewsRecommandationSystem; // Adjust this package to match your project structure

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            // Example: Replace with your actual DB credentials
            String url = "jdbc:mysql://localhost:3306/NewsRecommendationDB";  // Your DB URL
            String username = "root";  // Your DB username
            String password = "123456";  // Your DB password

            // Create and return a database connection
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to establish connection.");
        }
    }
}
