import java.util.*;

// Book class represents each book in the library
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    // Constructor
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Display book details
    void displayBook() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Issued: " + isIssued);
    }
}

// User class represents library users
class User {
    int userId;
    String name;

    // Constructor
    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    void displayUser() {
        System.out.println("User ID: " + userId + " | Name: " + name);
    }
}

// Main Library class
class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();

    // Add book
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Register user
    void addUser(User user) {
        users.add(user);
        System.out.println("User registered successfully.");
    }

    // Show available books
    void showBooks() {
        for (Book b : books) {
            b.displayBook();
        }
    }

    // Borrow book
    void borrowBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return book
    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Show Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();

                    library.addUser(new User(uid, name));
                    break;

                case 3:
                    library.showBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}