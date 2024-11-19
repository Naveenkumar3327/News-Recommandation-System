package NewsRecommandationSystem;

public class Article {
    private int id;
    private String title;
    private String content;
    private String category;

    // Constructor
    public Article(int id, String title, String content, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // You can add other methods like toString() for better readability
    @Override
    public String toString() {
        return "Article{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", content='" + content + '\'' +
               ", category='" + category + '\'' +
               '}';
    }
}
