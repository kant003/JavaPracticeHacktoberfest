import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Password Generator and Validator for Hacktoberfest
 * Author: Ankit Jha
 * Description: A comprehensive utility for generating secure passwords and validating password strength
 * Features: Custom length, character sets, strength validation, and security tips
 */
public class PasswordGeneratorValidator {
    
    // Character sets for password generation
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    // Password strength requirements
    private static final int MIN_LENGTH = 8;
    private static final int RECOMMENDED_LENGTH = 12;
    
    // Scanner and Random objects
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    /**
     * Main method to run the password utility
     */
    public static void main(String[] args) {
        System.out.println("=== Password Generator & Validator ===");
        System.out.println("🔐 Welcome to the Password Security Utility!");
        displaySecurityTips();
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    generatePassword();
                    break;
                case 2:
                    validatePassword();
                    break;
                case 3:
                    displayPasswordTips();
                    break;
                case 4:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
            
            if (continueProgram) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                clearScreen();
            }
        }
        
        System.out.println("🛡️ Stay secure! Goodbye!");
        scanner.close();
    }
    
    /**
     * Displays the main menu options
     */
    private static void displayMenu() {
        System.out.println("\n=== Choose an Option ===");
        System.out.println("1. 🎲 Generate Password");
        System.out.println("2. ✅ Validate Password");
        System.out.println("3. 💡 Password Security Tips");
        System.out.println("4. 🚪 Exit");
        System.out.print("\nEnter your choice (1-4): ");
    }
    
    /**
     * Gets user menu choice with input validation
     */
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return 0; // Invalid choice
        }
    }
    
    /**
     * Generates a custom password based on user preferences
     */
    private static void generatePassword() {
        System.out.println("\n=== Password Generator ===");
        
        // Get password length
        int length = getPasswordLength();
        
        // Get character set preferences
        boolean[] charSets = getCharacterSetPreferences();
        
        // Generate password
        String password = createPassword(length, charSets);
        
        // Display results
        System.out.println("\n🎉 Generated Password: " + password);
        
        // Analyze password strength
        PasswordStrength strength = analyzePassword(password);
        displayPasswordAnalysis(password, strength);
        
        // Offer to generate another
        if (askYesNo("Generate another password?")) {
            generatePassword();
        }
    }
    
    /**
     * Gets desired password length from user
     */
    private static int getPasswordLength() {
        while (true) {
            try {
                System.out.print("Enter password length (minimum " + MIN_LENGTH + ", recommended " + 
                                RECOMMENDED_LENGTH + "+): ");
                int length = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (length < MIN_LENGTH) {
                    System.out.println("⚠️ Password too short! Minimum length is " + MIN_LENGTH);
                    continue;
                }
                
                if (length < RECOMMENDED_LENGTH) {
                    System.out.println("⚠️ Warning: Password shorter than recommended length of " + 
                                     RECOMMENDED_LENGTH);
                }
                
                return length;
                
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Gets user preferences for character sets to include
     */
    private static boolean[] getCharacterSetPreferences() {
        boolean[] charSets = new boolean[4]; // [lowercase, uppercase, digits, special]
        
        System.out.println("\nCharacter Set Options:");
        charSets[0] = askYesNo("Include lowercase letters (a-z)?");
        charSets[1] = askYesNo("Include uppercase letters (A-Z)?");
        charSets[2] = askYesNo("Include digits (0-9)?");
        charSets[3] = askYesNo("Include special characters (!@#$%^&*)?");
        
        // Ensure at least one character set is selected
        if (!charSets[0] && !charSets[1] && !charSets[2] && !charSets[3]) {
            System.out.println("⚠️ No character sets selected! Enabling all sets for security.");
            charSets[0] = charSets[1] = charSets[2] = charSets[3] = true;
        }
        
        return charSets;
    }
    
    /**
     * Creates a password with specified length and character sets
     */
    private static String createPassword(int length, boolean[] charSets) {
        StringBuilder allowedChars = new StringBuilder();
        StringBuilder password = new StringBuilder();
        
        // Build allowed character string
        if (charSets[0]) allowedChars.append(LOWERCASE);
        if (charSets[1]) allowedChars.append(UPPERCASE);
        if (charSets[2]) allowedChars.append(DIGITS);
        if (charSets[3]) allowedChars.append(SPECIAL_CHARS);
        
        // Ensure at least one character from each selected set
        if (charSets[0]) password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        if (charSets[1]) password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        if (charSets[2]) password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        if (charSets[3]) password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        
        // Fill remaining length with random characters
        while (password.length() < length) {
            password.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        
        // Shuffle the password to avoid predictable patterns
        return shuffleString(password.toString());
    }
    
    /**
     * Shuffles characters in a string randomly
     */
    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
        return new String(chars);
    }
    
    /**
     * Validates an existing password and provides feedback
     */
    private static void validatePassword() {
        System.out.println("\n=== Password Validator ===");
        System.out.print("Enter password to validate: ");
        String password = scanner.nextLine();
        
        PasswordStrength strength = analyzePassword(password);
        displayPasswordAnalysis(password, strength);
        
        // Suggest improvements
        suggestImprovements(password, strength);
        
        if (askYesNo("Validate another password?")) {
            validatePassword();
        }
    }
    
    /**
     * Analyzes password strength and returns detailed assessment
     */
    private static PasswordStrength analyzePassword(String password) {
        PasswordStrength strength = new PasswordStrength();
        
        // Length check
        strength.length = password.length();
        strength.hasMinLength = password.length() >= MIN_LENGTH;
        strength.hasRecommendedLength = password.length() >= RECOMMENDED_LENGTH;
        
        // Character set checks
        strength.hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        strength.hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        strength.hasDigits = Pattern.compile("\\d").matcher(password).find();
        strength.hasSpecialChars = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?]").matcher(password).find();
        
        // Common pattern checks
        strength.hasRepeatingChars = hasRepeatingCharacters(password);
        strength.hasSequentialChars = hasSequentialChars(password);
        strength.isCommonPassword = isCommonPassword(password);
        
        // Calculate overall score
        strength.score = calculateStrengthScore(strength);
        strength.level = getStrengthLevel(strength.score);
        
        return strength;
    }
    
    /**
     * Checks for repeating characters (3+ in a row)
     */
    private static boolean hasRepeatingCharacters(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && 
                password.charAt(i) == password.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks for sequential characters (3+ in a row)
     */
    private static boolean hasSequentialChars(String password) {
        String lower = password.toLowerCase();
        for (int i = 0; i < lower.length() - 2; i++) {
            char c1 = lower.charAt(i);
            char c2 = lower.charAt(i + 1);
            char c3 = lower.charAt(i + 2);
            
            if ((c2 == c1 + 1 && c3 == c2 + 1) || (c2 == c1 - 1 && c3 == c2 - 1)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if password is commonly used (basic check)
     */
    private static boolean isCommonPassword(String password) {
        String[] commonPasswords = {
            "password", "123456", "password123", "admin", "qwerty",
            "letmein", "welcome", "monkey", "1234567890", "abc123"
        };
        
        String lowerPassword = password.toLowerCase();
        for (String common : commonPasswords) {
            if (lowerPassword.contains(common)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Calculates numerical strength score (0-100)
     */
    private static int calculateStrengthScore(PasswordStrength strength) {
        int score = 0;
        
        // Length scoring
        if (strength.length >= 8) score += 20;
        if (strength.length >= 12) score += 10;
        if (strength.length >= 16) score += 10;
        
        // Character variety scoring
        if (strength.hasLowercase) score += 10;
        if (strength.hasUppercase) score += 10;
        if (strength.hasDigits) score += 10;
        if (strength.hasSpecialChars) score += 15;
        
        // Bonus for character set diversity
        int charSetCount = 0;
        if (strength.hasLowercase) charSetCount++;
        if (strength.hasUppercase) charSetCount++;
        if (strength.hasDigits) charSetCount++;
        if (strength.hasSpecialChars) charSetCount++;
        
        if (charSetCount >= 3) score += 10;
        if (charSetCount == 4) score += 5;
        
        // Penalties
        if (strength.hasRepeatingChars) score -= 10;
        if (strength.hasSequentialChars) score -= 10;
        if (strength.isCommonPassword) score -= 20;
        
        return Math.max(0, Math.min(100, score));
    }
    
    /**
     * Determines strength level based on score
     */
    private static String getStrengthLevel(int score) {
        if (score >= 80) return "Very Strong";
        if (score >= 60) return "Strong";
        if (score >= 40) return "Moderate";
        if (score >= 20) return "Weak";
        return "Very Weak";
    }
    
    /**
     * Displays detailed password analysis
     */
    private static void displayPasswordAnalysis(String password, PasswordStrength strength) {
        System.out.println("\n=== Password Analysis ===");
        System.out.println("Password: " + maskPassword(password));
        System.out.println("Length: " + strength.length + " characters");
        System.out.printf("Strength Score: %d/100 (%s)%n", strength.score, strength.level);
        
        // Display strength indicator
        displayStrengthBar(strength.score);
        
        System.out.println("\n✅ Criteria Met:");
        if (strength.hasMinLength) System.out.println("  ✓ Minimum length (" + MIN_LENGTH + "+ chars)");
        if (strength.hasRecommendedLength) System.out.println("  ✓ Recommended length (" + RECOMMENDED_LENGTH + "+ chars)");
        if (strength.hasLowercase) System.out.println("  ✓ Contains lowercase letters");
        if (strength.hasUppercase) System.out.println("  ✓ Contains uppercase letters");
        if (strength.hasDigits) System.out.println("  ✓ Contains digits");
        if (strength.hasSpecialChars) System.out.println("  ✓ Contains special characters");
        
        System.out.println("\n❌ Issues Found:");
        if (!strength.hasMinLength) System.out.println("  ✗ Below minimum length");
        if (!strength.hasRecommendedLength) System.out.println("  ✗ Below recommended length");
        if (!strength.hasLowercase) System.out.println("  ✗ No lowercase letters");
        if (!strength.hasUppercase) System.out.println("  ✗ No uppercase letters");
        if (!strength.hasDigits) System.out.println("  ✗ No digits");
        if (!strength.hasSpecialChars) System.out.println("  ✗ No special characters");
        if (strength.hasRepeatingChars) System.out.println("  ✗ Contains repeating characters");
        if (strength.hasSequentialChars) System.out.println("  ✗ Contains sequential characters");
        if (strength.isCommonPassword) System.out.println("  ✗ Contains common password patterns");
    }
    
    /**
     * Displays visual strength bar
     */
    private static void displayStrengthBar(int score) {
        System.out.print("Strength: [");
        int bars = score / 10;
        for (int i = 0; i < 10; i++) {
            if (i < bars) {
                if (score >= 80) System.out.print("█");
                else if (score >= 60) System.out.print("▓");
                else if (score >= 40) System.out.print("▒");
                else System.out.print("░");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Masks password for display (shows first 2 and last 2 chars)
     */
    private static String maskPassword(String password) {
        if (password.length() <= 4) {
            return "*".repeat(password.length());
        }
        return password.substring(0, 2) + "*".repeat(password.length() - 4) + 
               password.substring(password.length() - 2);
    }
    
    /**
     * Suggests improvements for weak passwords
     */
    private static void suggestImprovements(String password, PasswordStrength strength) {
        if (strength.score >= 80) {
            System.out.println("\n🎉 Excellent! Your password is very strong!");
            return;
        }
        
        System.out.println("\n💡 Suggestions for Improvement:");
        
        if (!strength.hasMinLength) {
            System.out.println("  • Increase length to at least " + MIN_LENGTH + " characters");
        }
        if (!strength.hasRecommendedLength) {
            System.out.println("  • Consider using " + RECOMMENDED_LENGTH + "+ characters for better security");
        }
        if (!strength.hasLowercase) {
            System.out.println("  • Add lowercase letters (a-z)");
        }
        if (!strength.hasUppercase) {
            System.out.println("  • Add uppercase letters (A-Z)");
        }
        if (!strength.hasDigits) {
            System.out.println("  • Add numbers (0-9)");
        }
        if (!strength.hasSpecialChars) {
            System.out.println("  • Add special characters (!@#$%^&*)");
        }
        if (strength.hasRepeatingChars) {
            System.out.println("  • Avoid repeating characters (aaa, 111)");
        }
        if (strength.hasSequentialChars) {
            System.out.println("  • Avoid sequential characters (abc, 123)");
        }
        if (strength.isCommonPassword) {
            System.out.println("  • Avoid common words and patterns");
        }
    }
    
    /**
     * Displays general password security tips
     */
    private static void displayPasswordTips() {
        System.out.println("\n=== Password Security Tips ===");
        System.out.println("🔐 Best Practices:");
        System.out.println("  • Use unique passwords for each account");
        System.out.println("  • Enable two-factor authentication when available");
        System.out.println("  • Use a password manager");
        System.out.println("  • Change passwords if you suspect compromise");
        System.out.println("  • Don't share passwords or write them down");
        System.out.println("  • Avoid using personal information");
        System.out.println("  • Consider using passphrases with random words");
        System.out.println("  • Regular password updates for sensitive accounts");
    }
    
    /**
     * Displays initial security tips
     */
    private static void displaySecurityTips() {
        System.out.println("\n💡 Quick Security Reminder:");
        System.out.println("Strong passwords are your first line of defense!");
        System.out.println("Use this tool to generate secure passwords and check existing ones.\n");
    }
    
    /**
     * Asks a yes/no question and returns boolean result
     */
    private static boolean askYesNo(String question) {
        System.out.print(question + " (y/n): ");
        char response = scanner.nextLine().toLowerCase().charAt(0);
        return response == 'y';
    }
    
    /**
     * Clears screen (works on most terminals)
     */
    private static void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }
    
    /**
     * Inner class to hold password strength analysis results
     */
    private static class PasswordStrength {
        int length;
        boolean hasMinLength;
        boolean hasRecommendedLength;
        boolean hasLowercase;
        boolean hasUppercase;
        boolean hasDigits;
        boolean hasSpecialChars;
        boolean hasRepeatingChars;
        boolean hasSequentialChars;
        boolean isCommonPassword;
        int score;
        String level;
    }
}
