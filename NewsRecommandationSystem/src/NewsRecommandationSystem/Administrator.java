package NewsRecommandationSystem;

public class Administrator extends User {
    private DatabaseManager dbManager;

    public Administrator(String username, String password, DatabaseManager dbManager) {
        super(username, password); 
        this.dbManager = dbManager;
    }

    public void addUser(String username, String password) {
        dbManager.addUserToDatabase(username, password); 
    }

    public void removeUser(String username) {
        dbManager.removeUserFromDatabase(username);
    }

    public void addArticle(String title, String content, String category) {
        dbManager.addArticleToDatabase(title, content, category);
    }

    public void removeArticle(int articleId) {
        dbManager.removeArticleFromDatabase(articleId);
    }

    public void viewFeedback() {
        dbManager.viewAllFeedback(); 
    }

    @Override
    public void viewArticles() {
      
        dbManager.fetchAllArticles(); 
    }
}
