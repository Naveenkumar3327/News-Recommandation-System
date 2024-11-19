package NewsRecommandationSystem;

import java.sql.*;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/NewsRecommendationDB";
    private static final String USER = "root";
    private static final String PASS = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Validate User credentials
    public boolean validateUser(String username, String password) {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                return rs.next();  // If a matching user is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Insert Feedback
    public void insertFeedback(String username, int articleId, int rating) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO feedback (user_id, article_id, rating) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, getUserIdByUsername(username)); // Get user ID from username
                stmt.setInt(2, articleId);
                stmt.setInt(3, rating);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Feedback submitted successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all feedback
    public void viewAllFeedback() {
        try (Connection conn = getConnection()) {
            String query = "SELECT feedback.id, users.username, articles.title, feedback.rating, feedback.feedback_text FROM feedback "
                    + "JOIN users ON feedback.user_id = users.id "
                    + "JOIN articles ON feedback.article_id = articles.id";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int feedbackId = rs.getInt("id");
                    String username = rs.getString("username");
                    String articleTitle = rs.getString("title");
                    int rating = rs.getInt("rating");
                    String feedbackText = rs.getString("feedback_text");
                    System.out.println("Feedback ID: " + feedbackId);
                    System.out.println("User: " + username);
                    System.out.println("Article: " + articleTitle);
                    System.out.println("Rating: " + rating);
                    System.out.println("Feedback: " + feedbackText);
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add User to the database
    public void addUserToDatabase(String username, String password) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.executeUpdate();
                System.out.println("User added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove User from the database
    public void removeUserFromDatabase(String username) {
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.executeUpdate();
                System.out.println("User removed successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add Article to the database
    public void addArticleToDatabase(String title, String content, String category) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO articles (title, content, category) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, title);
                stmt.setString(2, content);
                stmt.setString(3, category);
                stmt.executeUpdate();
                System.out.println("Article added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove Article from the database
    public void removeArticleFromDatabase(int articleId) {
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM articles WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, articleId);
                stmt.executeUpdate();
                System.out.println("Article removed successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get user ID by username
    private int getUserIdByUsername(String username) throws SQLException {
        String query = "SELECT id FROM users WHERE username = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new SQLException("User not found");
            }
        }
    }

    // Fetch all articles
    public void fetchAllArticles() {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM articles";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int articleId = rs.getInt("id");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    String category = rs.getString("category");
                    System.out.println("Article ID: " + articleId);
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + content);
                    System.out.println("Category: " + category);
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Articles by category
    public void fetchArticlesByCategory(String category) {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM articles WHERE category = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, category);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int articleId = rs.getInt("id");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    System.out.println("Article ID: " + articleId);
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + content);
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch all categories
    public void fetchCategories() {
        try (Connection conn = getConnection()) {
            String query = "SELECT DISTINCT category FROM articles";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String category = rs.getString("category");
                    System.out.println("Category: " + category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
