package NewsRecommandationSystem;

public class NormalUser extends User {
    private DatabaseManager dbManager;

    public NormalUser(String username, String password, DatabaseManager dbManager) {
        super(username, password); 
        this.dbManager = dbManager;
    }

    @Override
    public void viewArticles() {
      
        String category = "General"; 
        dbManager.fetchArticlesByCategory(category); 
    }

    public void giveFeedback(int articleId, int rating) {
        dbManager.insertFeedback(username, articleId, rating);
    }
}
