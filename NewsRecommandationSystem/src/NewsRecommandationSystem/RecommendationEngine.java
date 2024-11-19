package NewsRecommandationSystem;

import java.util.List;

public class RecommendationEngine {
    private DatabaseManager dbManager;

    // Constructor
    public RecommendationEngine(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Method for Collaborative Filtering: Recommends articles based on the user's reading history
    public List<Article> recommendArticles(int userId) {
        // Fetch user preferences and reading history for collaborative filtering
        // Assume getCollaborativeRecommendations returns a list of recommended articles based on the userId
        return dbManager.getCollaborativeRecommendations(userId);
    }

    // Method for Content-Based Filtering: Recommends articles based on the category the user is interested in
    public List<Article> contentBasedRecommendations(String category) {
        // Fetch articles based on the given category
        return dbManager.fetchArticlesByCategory(category);
    }
}
