/**
 * Email Validator
 * =================
 * A simple yet robust email validation utility that checks if an email
 * address follows standard email format rules.
 * 
 * Features:
 * - Validates basic email structure (user@domain.ext)
 * - Checks for valid characters
 * - Verifies domain and TLD format
 * - Handles common edge cases
 * 
 * Author: Hacktoberfest 2025 Contributor
 * Date: October 20, 2025
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
    
    // Regular expression pattern for email validation
    // Matches: username + @ + domain + . + top-level domain
    private static final String EMAIL_PATTERN = 
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    
    /**
     * Validates if the given email address is in correct format
     * 
     * @param email The email address to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        // Check if email is null or empty
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        
        // Remove leading and trailing whitespace
        email = email.trim();
        
        // Check length constraints
        if (email.length() > 254) { // Maximum email length per RFC 5321
            return false;
        }
        
        // Match against pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    /**
     * Validates email and provides detailed feedback
     * 
     * @param email The email address to validate
     * @return Validation message with details
     */
    public static String validateWithFeedback(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "❌ Email cannot be empty";
        }
        
        email = email.trim();
        
        if (email.length() > 254) {
            return "❌ Email is too long (max 254 characters)";
        }
        
        if (!email.contains("@")) {
            return "❌ Email must contain @ symbol";
        }
        
        if (!email.contains(".")) {
            return "❌ Email must contain a domain with extension";
        }
        
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return "❌ Email must have exactly one @ symbol";
        }
        
        if (parts[0].isEmpty()) {
            return "❌ Email must have a username before @";
        }
        
        if (parts[1].isEmpty() || !parts[1].contains(".")) {
            return "❌ Email must have a valid domain after @";
        }
        
        if (isValidEmail(email)) {
            return "✅ Valid email address";
        } else {
            return "❌ Email contains invalid characters or format";
        }
    }
    
    /**
     * Main method - demonstrates email validation with examples
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("EMAIL VALIDATOR - Hacktoberfest 2025");
        System.out.println("=".repeat(60));
        
        // Test cases with various email formats
        String[] testEmails = {
            "user@example.com",           // Valid
            "john.doe@company.co.uk",     // Valid with subdomain
            "contact+tag@domain.org",     // Valid with + character
            "invalid.email",              // Invalid - no @
            "@example.com",               // Invalid - no username
            "user@",                      // Invalid - no domain
            "user@domain",                // Invalid - no extension
            "user name@domain.com",       // Invalid - space in username
            "user@domain..com",           // Invalid - double dot
            "",                           // Invalid - empty
            "test_user123@company.com",   // Valid with underscore and numbers
            "admin@sub.domain.com"        // Valid with subdomain
        };
        
        System.out.println("\nValidation Results:\n");
        
        // Test each email and display results
        for (String email : testEmails) {
            String displayEmail = email.isEmpty() ? "(empty string)" : email;
            boolean isValid = isValidEmail(email);
            String feedback = validateWithFeedback(email);
            
            System.out.printf("Email: %-30s | %s%n", displayEmail, feedback);
        }
        
        System.out.println("\n" + "=".repeat(60));
        
        // Interactive validation (if running with scanner)
        System.out.println("\nUsage Example:");
        System.out.println("  boolean valid = EmailValidator.isValidEmail(\"user@example.com\");");
        System.out.println("  String feedback = EmailValidator.validateWithFeedback(\"user@example.com\");");
    }
}
