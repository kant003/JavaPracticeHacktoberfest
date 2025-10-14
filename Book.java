import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Book Class for Library Management System
 * Author: GitHub Copilot
 * Description: Represents a book with all its properties and borrowing status
 */
public class Book {
    
    // Private fields to store book information
    private int id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private boolean borrowed;
    private String borrowerName;
    private Date borrowDate;
    private Date addedDate;
    
    // Static formatter for dates
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Constructor to create a new book
     * @param id The unique ID for the book
     * @param title The book title
     * @param author The author name
     * @param genre The book genre/category
     * @param publicationYear The year the book was published
     */
    public Book(int id, String title, String author, String genre, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.borrowed = false;
        this.borrowerName = null;
        this.borrowDate = null;
        this.addedDate = new Date();
    }
    
    /**
     * Gets the book ID
     * @return The book ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the book title
     * @return The book title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the book title
     * @param title The new title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the author name
     * @return The author name
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Sets the author name
     * @param author The new author name
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Gets the book genre
     * @return The book genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Sets the book genre
     * @param genre The new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * Gets the publication year
     * @return The publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }
    
    /**
     * Sets the publication year
     * @param publicationYear The new publication year
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    /**
     * Checks if the book is currently borrowed
     * @return true if borrowed, false if available
     */
    public boolean isBorrowed() {
        return borrowed;
    }
    
    /**
     * Sets the borrowing status of the book
     * @param borrowed The borrowing status
     * @param borrowerName The name of the borrower (null if returning)
     */
    public void setBorrowed(boolean borrowed, String borrowerName) {
        this.borrowed = borrowed;
        this.borrowerName = borrowerName;
        
        if (borrowed) {
            this.borrowDate = new Date();
        } else {
            // When returning, keep the borrower name and date for history
            // In a real system, you might want to keep a borrowing history
            this.borrowDate = null;
        }
    }
    
    /**
     * Gets the name of the current borrower
     * @return The borrower name, or null if not borrowed
     */
    public String getBorrowerName() {
        return borrowerName;
    }
    
    /**
     * Gets the borrow date as formatted string
     * @return The borrow date, or "Not borrowed" if available
     */
    public String getBorrowDate() {
        if (borrowDate == null) {
            return "Not borrowed";
        }
        return dateFormat.format(borrowDate);
    }
    
    /**
     * Gets the date when the book was added to the library
     * @return The formatted added date
     */
    public String getAddedDate() {
        return dateFormat.format(addedDate);
    }
    
    /**
     * Gets the raw borrow date object
     * @return The borrow Date object, or null if not borrowed
     */
    public Date getBorrowDateObject() {
        if (borrowDate == null) {
            return null;
        }
        return new Date(borrowDate.getTime()); // Return copy for security
    }
    
    /**
     * Gets the raw added date object
     * @return The added Date object
     */
    public Date getAddedDateObject() {
        return new Date(addedDate.getTime()); // Return copy for security
    }
    
    /**
     * Calculates how many days the book has been borrowed
     * @return Number of days borrowed, or 0 if not borrowed
     */
    public long getDaysBorrowed() {
        if (!borrowed || borrowDate == null) {
            return 0;
        }
        
        Date now = new Date();
        long diffInMillis = now.getTime() - borrowDate.getTime();
        return diffInMillis / (1000 * 60 * 60 * 24); // Convert to days
    }
    
    /**
     * Checks if the book is overdue (borrowed for more than specified days)
     * @param maxDays Maximum allowed borrowing days
     * @return true if overdue, false otherwise
     */
    public boolean isOverdue(int maxDays) {
        return borrowed && getDaysBorrowed() > maxDays;
    }
    
    /**
     * Gets the age of the book in years
     * @return Age in years from publication to current year
     */
    public int getBookAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - publicationYear;
    }
    
    /**
     * Checks if the book matches a search term in title, author, or genre
     * @param searchTerm The term to search for
     * @return true if any field contains the search term
     */
    public boolean matches(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return false;
        }
        
        String term = searchTerm.toLowerCase();
        return title.toLowerCase().contains(term) ||
               author.toLowerCase().contains(term) ||
               genre.toLowerCase().contains(term);
    }
    
    /**
     * Gets the availability status as a formatted string
     * @return Status string with icon
     */
    public String getAvailabilityStatus() {
        if (borrowed) {
            return "🔴 Borrowed by " + borrowerName;
        } else {
            return "🟢 Available";
        }
    }
    
    /**
     * Gets a short status icon
     * @return Status icon
     */
    public String getStatusIcon() {
        return borrowed ? "🔴" : "🟢";
    }
    
    /**
     * Creates a formatted summary of the book
     * @return Formatted book summary
     */
    public String getSummary() {
        String status = borrowed ? "🔴 Borrowed" : "🟢 Available";
        return String.format("[%d] %s - \"%s\" by %s (%s, %d)", 
            id, status, title, author, genre, publicationYear);
    }
    
    /**
     * Creates a detailed description of the book
     * @return Detailed book information
     */
    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Book ID: ").append(id).append("\n");
        info.append("Title: ").append(title).append("\n");
        info.append("Author: ").append(author).append("\n");
        info.append("Genre: ").append(genre).append("\n");
        info.append("Publication Year: ").append(publicationYear).append("\n");
        info.append("Age: ").append(getBookAge()).append(" years\n");
        info.append("Status: ").append(getAvailabilityStatus()).append("\n");
        info.append("Added to Library: ").append(getAddedDate()).append("\n");
        
        if (borrowed) {
            info.append("Borrowed Date: ").append(getBorrowDate()).append("\n");
            info.append("Days Borrowed: ").append(getDaysBorrowed()).append("\n");
        }
        
        return info.toString();
    }
    
    /**
     * Returns a string representation of the book
     * @return String containing book information
     */
    @Override
    public String toString() {
        return String.format("Book{id=%d, title='%s', author='%s', genre='%s', year=%d, borrowed=%s}", 
                           id, title, author, genre, publicationYear, borrowed);
    }
    
    /**
     * Checks if two books are equal based on their ID
     * @param obj The object to compare with
     * @return true if books have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Book book = (Book) obj;
        return id == book.id;
    }
    
    /**
     * Generates hash code based on book ID
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}