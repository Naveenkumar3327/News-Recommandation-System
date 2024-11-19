package NewsRecommandationSystem;

import java.util.Scanner;

public class NewsRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        while (true) {
            System.out.println("---------Welcome to News Recommendation System----------------");
            System.out.println();
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Admin Login
                    System.out.print("Enter Admin Username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = scanner.nextLine();

                    if ("Naveenkumar".equals(adminUsername) && "Naveen@123".equals(adminPassword)) {
                        System.out.println("Admin Login Successful!");
                        System.out.println();

                        while (true) {
                            System.out.println("1. Add User");
                            System.out.println("2. Remove User");
                            System.out.println("3. Add Article");
                            System.out.println("4. Remove Article");
                            System.out.println("5. View Feedback");
                            System.out.println("6. Logout");
                            System.out.print("Enter choice: ");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (adminChoice == 1) {
                                System.out.print("Enter New Username: ");
                                String newUser = scanner.nextLine();
                                System.out.print("Enter Password: ");
                                String newPassword = scanner.nextLine();
                                dbManager.addUserToDatabase(newUser, newPassword);
                            } else if (adminChoice == 2) {
                                System.out.print("Enter Username to Remove: ");
                                String removeUser = scanner.nextLine();
                                dbManager.removeUserFromDatabase(removeUser);
                            } else if (adminChoice == 3) {
                                System.out.print("Enter Article Title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter Content: ");
                                String content = scanner.nextLine();
                                System.out.print("Enter Category: ");
                                String category = scanner.nextLine();
                                dbManager.addArticleToDatabase(title, content, category);
                            } else if (adminChoice == 4) {
                                System.out.print("Enter Article ID to Remove: ");
                                int articleId = scanner.nextInt();
                                dbManager.removeArticleFromDatabase(articleId);
                            } else if (adminChoice == 5) {
                                dbManager.viewAllFeedback();  // Assuming this method is defined in DatabaseManager
                            } else if (adminChoice == 6) {
                                break;  // Logout
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                            System.out.println(); // Add space after each admin choice
                        }
                    } else {
                        System.out.println("Invalid Admin Credentials.");
                    }
                    break;

                case 2:
                    // User Login
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();

                    if (dbManager.validateUser(username, password)) {
                        System.out.println("User Login Successful!");
                        System.out.println();

                        while (true) {
                            System.out.println("1. View Articles");
                            System.out.println("2. Give Feedback");
                            System.out.println("3. Logout");
                            System.out.print("Enter choice: ");
                            int userChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (userChoice == 1) {
                                System.out.println("Would you like to (1) View all Articles or (2) View Articles by Category?");
                                int viewChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                if (viewChoice == 1) {
                                    dbManager.fetchAllArticles();  // View all articles
                                } else if (viewChoice == 2) {
                                    System.out.println("Available Categories:");
                                    dbManager.fetchCategories();  // Show available categories
                                    System.out.print("Enter the category name to get news: ");
                                    String category = scanner.nextLine();
                                    dbManager.fetchArticlesByCategory(category);  // View articles by category
                                } else {
                                    System.out.println("Invalid choice. Please enter 1 or 2.");
                                }
                            } else if (userChoice == 2) {
                                System.out.print("Enter Article ID to Give Feedback: ");
                                int articleId = scanner.nextInt();
                                System.out.print("Enter Rating (1-5): ");
                                int rating = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                dbManager.insertFeedback(username, articleId, rating);
                            } else if (userChoice == 3) {
                                break;  // Logout
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                            System.out.println(); // Add space after each user choice
                        }
                    } else {
                        System.out.println("Invalid User Credentials.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add space after each loop iteration
        }
    }
}
