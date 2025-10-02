import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library Management System for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A simple system to manage books and library operations
 */
public class LibraryManager {
    
    // List to store all books in the library
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int bookIdCounter = 1;
    
    /**
     * Main method to run the library management system
     */
    public static void main(String[] args) {
        System.out.println("=== Welcome to Simple Library Management System ===");
        System.out.println("📚 Manage your book collection with ease!");
        
        // Add some sample books for demonstration
        addSampleBooks();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    viewAvailableBooks();
                    break;
                case 7:
                    viewBorrowedBooks();
                    break;
                case 8:
                    removeBook();
                    break;
                case 9:
                    displayStatistics();
                    break;
                case 10:
                    running = false;
                    System.out.println("Thank you for using Library Management System! Happy reading! 📖");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu
     */
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📚 LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. 📖 Add New Book");
        System.out.println("2. 📋 View All Books");
        System.out.println("3. 🔍 Search Books");
        System.out.println("4. 📤 Borrow Book");
        System.out.println("5. 📥 Return Book");
        System.out.println("6. ✅ View Available Books");
        System.out.println("7. 📅 View Borrowed Books");
        System.out.println("8. 🗑️  Remove Book");
        System.out.println("9. 📊 Library Statistics");
        System.out.println("10. 🚪 Exit");
        System.out.println("=".repeat(60));
        System.out.print("Enter your choice (1-10): ");
    }
    
    /**
     * Gets user choice with error handling
     */
    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    /**
     * Adds sample books for demonstration
     */
    private static void addSampleBooks() {
        books.add(new Book(bookIdCounter++, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 2019));
        books.add(new Book(bookIdCounter++, "To Kill a Mockingbird", "Harper Lee", "Fiction", 2018));
        books.add(new Book(bookIdCounter++, "1984", "George Orwell", "Dystopian Fiction", 2020));
        books.add(new Book(bookIdCounter++, "Pride and Prejudice", "Jane Austen", "Romance", 2017));
        books.add(new Book(bookIdCounter++, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 2019));
        
        // Mark some books as borrowed for demonstration
        books.get(1).setBorrowed(true, "Alice Johnson");
        books.get(3).setBorrowed(true, "Bob Smith");
    }
    
    /**
     * Adds a new book to the library
     */
    private static void addBook() {
        System.out.println("\n📖 Add New Book");
        System.out.println("-".repeat(40));
        
        try {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine().trim();
            
            if (title.isEmpty()) {
                System.out.println("❌ Book title cannot be empty!");
                return;
            }
            
            System.out.print("Enter author name: ");
            String author = scanner.nextLine().trim();
            
            if (author.isEmpty()) {
                System.out.println("❌ Author name cannot be empty!");
                return;
            }
            
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine().trim();
            
            if (genre.isEmpty()) {
                genre = "General"; // Default genre
            }
            
            System.out.print("Enter publication year: ");
            int year = scanner.nextInt();
            
            // Validate year
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            if (year < 1000 || year > currentYear + 1) {
                System.out.println("❌ Invalid publication year!");
                return;
            }
            
            Book newBook = new Book(bookIdCounter++, title, author, genre, year);
            books.add(newBook);
            
            System.out.println("✅ Book added successfully!");
            System.out.println("Book ID: " + newBook.getId());
            System.out.println("Title: " + newBook.getTitle());
            System.out.println("Author: " + newBook.getAuthor());
            System.out.println("Genre: " + newBook.getGenre());
            System.out.println("Year: " + newBook.getPublicationYear());
            
        } catch (Exception e) {
            System.out.println("❌ Error adding book! Please check your input.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Views all books in the library
     */
    private static void viewAllBooks() {
        System.out.println("\n📋 All Books in Library");
        System.out.println("=".repeat(100));
        
        if (books.isEmpty()) {
            System.out.println("📭 No books found in the library!");
            return;
        }
        
        System.out.printf("%-5s %-30s %-20s %-15s %-6s %-10s %-15s%n", 
            "ID", "Title", "Author", "Genre", "Year", "Status", "Borrower");
        System.out.println("-".repeat(100));
        
        for (Book book : books) {
            String status = book.isBorrowed() ? "🔴 Borrowed" : "🟢 Available";
            String borrower = book.isBorrowed() ? book.getBorrowerName() : "-";
            
            System.out.printf("%-5d %-30s %-20s %-15s %-6d %-10s %-15s%n",
                book.getId(),
                truncateString(book.getTitle(), 28),
                truncateString(book.getAuthor(), 18),
                truncateString(book.getGenre(), 13),
                book.getPublicationYear(),
                status,
                truncateString(borrower, 13));
        }
        
        System.out.println("\nTotal books: " + books.size());
    }
    
    /**
     * Searches for books by title, author, or genre
     */
    private static void searchBooks() {
        System.out.println("\n🔍 Search Books");
        System.out.println("-".repeat(30));
        
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Genre");
        System.out.print("Enter search type (1-3): ");
        
        try {
            int searchType = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            System.out.print("Enter search term: ");
            String searchTerm = scanner.nextLine().trim().toLowerCase();
            
            if (searchTerm.isEmpty()) {
                System.out.println("❌ Search term cannot be empty!");
                return;
            }
            
            System.out.println("\nSearch results:");
            System.out.println("-".repeat(80));
            
            int count = 0;
            for (Book book : books) {
                boolean matches = false;
                
                switch (searchType) {
                    case 1: // Title
                        matches = book.getTitle().toLowerCase().contains(searchTerm);
                        break;
                    case 2: // Author
                        matches = book.getAuthor().toLowerCase().contains(searchTerm);
                        break;
                    case 3: // Genre
                        matches = book.getGenre().toLowerCase().contains(searchTerm);
                        break;
                    default:
                        System.out.println("Invalid search type!");
                        return;
                }
                
                if (matches) {
                    String status = book.isBorrowed() ? "🔴 Borrowed" : "🟢 Available";
                    System.out.printf("%d. [%s] %s by %s (%s, %d)%n",
                        book.getId(), status, book.getTitle(), book.getAuthor(), 
                        book.getGenre(), book.getPublicationYear());
                    count++;
                }
            }
            
            if (count == 0) {
                System.out.println("📭 No books found matching: \"" + searchTerm + "\"");
            } else {
                System.out.println("\nFound " + count + " matching book(s).");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Handles borrowing a book
     */
    private static void borrowBook() {
        System.out.println("\n📤 Borrow Book");
        System.out.println("-".repeat(30));
        
        // Show available books
        viewAvailableBooks();
        
        if (getAvailableBookCount() == 0) {
            return;
        }
        
        System.out.print("Enter book ID to borrow: ");
        try {
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            Book book = findBookById(bookId);
            
            if (book == null) {
                System.out.println("❌ Book with ID " + bookId + " not found!");
                return;
            }
            
            if (book.isBorrowed()) {
                System.out.println("❌ Book is already borrowed by: " + book.getBorrowerName());
                return;
            }
            
            System.out.print("Enter borrower name: ");
            String borrowerName = scanner.nextLine().trim();
            
            if (borrowerName.isEmpty()) {
                System.out.println("❌ Borrower name cannot be empty!");
                return;
            }
            
            book.setBorrowed(true, borrowerName);
            
            System.out.println("✅ Book borrowed successfully!");
            System.out.println("📖 Book: " + book.getTitle());
            System.out.println("👤 Borrower: " + borrowerName);
            System.out.println("📅 Borrowed on: " + book.getBorrowDate());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid book ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Handles returning a book
     */
    private static void returnBook() {
        System.out.println("\n📥 Return Book");
        System.out.println("-".repeat(30));
        
        // Show borrowed books
        viewBorrowedBooks();
        
        if (getBorrowedBookCount() == 0) {
            return;
        }
        
        System.out.print("Enter book ID to return: ");
        try {
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            
            if (book == null) {
                System.out.println("❌ Book with ID " + bookId + " not found!");
                return;
            }
            
            if (!book.isBorrowed()) {
                System.out.println("❌ Book is not currently borrowed!");
                return;
            }
            
            String previousBorrower = book.getBorrowerName();
            book.setBorrowed(false, null);
            
            System.out.println("✅ Book returned successfully!");
            System.out.println("📖 Book: " + book.getTitle());
            System.out.println("👤 Returned by: " + previousBorrower);
            System.out.println("📅 Returned on: " + java.time.LocalDate.now());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid book ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Views only available books
     */
    private static void viewAvailableBooks() {
        System.out.println("\n✅ Available Books");
        System.out.println("=".repeat(60));
        
        int count = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.printf("%d. %s by %s (%s, %d)%n",
                    book.getId(), book.getTitle(), book.getAuthor(), 
                    book.getGenre(), book.getPublicationYear());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("📭 No books available for borrowing!");
        } else {
            System.out.println("\nTotal available books: " + count);
        }
    }
    
    /**
     * Views only borrowed books
     */
    private static void viewBorrowedBooks() {
        System.out.println("\n📅 Borrowed Books");
        System.out.println("=".repeat(70));
        
        int count = 0;
        for (Book book : books) {
            if (book.isBorrowed()) {
                System.out.printf("%d. %s by %s - Borrowed by: %s (Date: %s)%n",
                    book.getId(), book.getTitle(), book.getAuthor(), 
                    book.getBorrowerName(), book.getBorrowDate().substring(0, 10));
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("📭 No books are currently borrowed!");
        } else {
            System.out.println("\nTotal borrowed books: " + count);
        }
    }
    
    /**
     * Removes a book from the library
     */
    private static void removeBook() {
        System.out.println("\n🗑️ Remove Book");
        System.out.println("-".repeat(30));
        
        viewAllBooks();
        
        if (books.isEmpty()) {
            return;
        }
        
        System.out.print("Enter book ID to remove: ");
        try {
            int bookId = scanner.nextInt();
            Book book = findBookById(bookId);
            
            if (book == null) {
                System.out.println("❌ Book with ID " + bookId + " not found!");
                return;
            }
            
            if (book.isBorrowed()) {
                System.out.println("❌ Cannot remove book! It is currently borrowed by: " + book.getBorrowerName());
                System.out.print("Return the book first? (y/n): ");
                scanner.nextLine(); // Clear buffer
                char choice = scanner.nextLine().toLowerCase().charAt(0);
                
                if (choice == 'y') {
                    book.setBorrowed(false, null);
                    System.out.println("✅ Book returned automatically.");
                } else {
                    System.out.println("❌ Book removal cancelled.");
                    return;
                }
            }
            
            books.remove(book);
            System.out.println("🗑️ Book removed successfully!");
            System.out.println("Removed: " + book.getTitle() + " by " + book.getAuthor());
            
        } catch (Exception e) {
            System.out.println("❌ Invalid book ID! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Displays library statistics
     */
    private static void displayStatistics() {
        System.out.println("\n📊 Library Statistics");
        System.out.println("=".repeat(50));
        
        if (books.isEmpty()) {
            System.out.println("📭 No books available for statistics!");
            return;
        }
        
        int totalBooks = books.size();
        int availableBooks = getAvailableBookCount();
        int borrowedBooks = getBorrowedBookCount();
        
        // Calculate genre distribution
        java.util.Map<String, Integer> genreCount = new java.util.HashMap<>();
        for (Book book : books) {
            genreCount.put(book.getGenre(), genreCount.getOrDefault(book.getGenre(), 0) + 1);
        }
        
        double borrowRate = totalBooks > 0 ? (double) borrowedBooks / totalBooks * 100 : 0;
        
        System.out.println("📈 General Statistics:");
        System.out.println("  Total Books: " + totalBooks);
        System.out.println("  ✅ Available: " + availableBooks);
        System.out.println("  📤 Borrowed: " + borrowedBooks);
        System.out.printf("  📊 Borrow Rate: %.1f%%\n", borrowRate);
        
        System.out.println("\n📚 Genre Distribution:");
        for (java.util.Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " books");
        }
        
        // Library status message
        if (borrowRate >= 70) {
            System.out.println("\n🔥 Popular library! High borrowing activity!");
        } else if (borrowRate >= 40) {
            System.out.println("\n👍 Good circulation! Decent borrowing activity!");
        } else if (borrowRate >= 20) {
            System.out.println("\n📚 Moderate activity. Consider promoting more books!");
        } else {
            System.out.println("\n💡 Low activity. Maybe add more popular titles!");
        }
    }
    
    // Helper methods
    
    /**
     * Finds a book by its ID
     */
    private static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Gets the count of available books
     */
    private static int getAvailableBookCount() {
        int count = 0;
        for (Book book : books) {
            if (!book.isBorrowed()) count++;
        }
        return count;
    }
    
    /**
     * Gets the count of borrowed books
     */
    private static int getBorrowedBookCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isBorrowed()) count++;
        }
        return count;
    }
    
    /**
     * Truncates a string to specified length
     */
    private static String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }
}