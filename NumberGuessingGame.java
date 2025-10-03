import java.util.Scanner;
import java.util.Random;

/**
 * Number Guessing Game for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A fun guessing game where player tries to guess a random number
 */
public class NumberGuessingGame {
    
    // Game constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;
    
    // Scanner and Random objects
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    // Game statistics
    private static int gamesPlayed = 0;
    private static int gamesWon = 0;
    
    /**
     * Main method to run the number guessing game
     */
    public static void main(String[] args) {
        System.out.println("=== Welcome to Number Guessing Game ===");
        System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it!");
        
        boolean playAgain = true;
        
        // Main game loop
        while (playAgain) {
            playGame();
            playAgain = askPlayAgain();
        }
        
        // Display final statistics
        displayFinalStats();
        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }
    
    /**
     * Main game logic for a single round
     */
    private static void playGame() {
        gamesPlayed++;
        
        // Generate random number
        int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        boolean hasWon = false;
        
        System.out.println("\n=== Game " + gamesPlayed + " ===");
        System.out.println("New number generated! Start guessing...");
        
        // Game loop for current round
        while (attempts < MAX_ATTEMPTS && !hasWon) {
            attempts++;
            System.out.print("\nAttempt " + attempts + "/" + MAX_ATTEMPTS + " - Enter your guess: ");
            
            try {
                int guess = scanner.nextInt();
                
                // Validate guess range
                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    System.out.println("Please guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
                    attempts--; // Don't count invalid attempts
                    continue;
                }
                
                // Check the guess
                if (guess == secretNumber) {
                    hasWon = true;
                    gamesWon++;
                    System.out.println("🎉 Congratulations! You guessed it right!");
                    System.out.println("The number was " + secretNumber);
                    System.out.println("You won in " + attempts + " attempts!");
                    
                    // Give performance feedback
                    givePerformanceFeedback(attempts);
                    
                } else if (guess < secretNumber) {
                    System.out.println("📈 Too low! Try a higher number.");
                    giveHint(guess, secretNumber, attempts);
                } else {
                    System.out.println("📉 Too high! Try a lower number.");
                    giveHint(guess, secretNumber, attempts);
                }
                
                // Show remaining attempts
                if (!hasWon && attempts < MAX_ATTEMPTS) {
                    System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                attempts--; // Don't count invalid attempts
            }
        }
        
        // Game over - check if player lost
        if (!hasWon) {
            System.out.println("\n💔 Game Over! You've used all " + MAX_ATTEMPTS + " attempts.");
            System.out.println("The number was " + secretNumber);
        }
        
        // Display current statistics
        displayCurrentStats();
    }
    
    /**
     * Provides hints based on how close the guess is
     */
    private static void giveHint(int guess, int secretNumber, int attempts) {
        int difference = Math.abs(guess - secretNumber);
        
        if (attempts <= 2) { // Give hints after first 2 attempts
            if (difference <= 5) {
                System.out.println("🔥 Very close! You're getting hot!");
            } else if (difference <= 15) {
                System.out.println("🌡️ Getting warmer...");
            } else if (difference <= 30) {
                System.out.println("❄️ Still cold...");
            } else {
                System.out.println("🧊 Very cold!");
            }
        }
    }
    
    /**
     * Gives performance feedback based on number of attempts
     */
    private static void givePerformanceFeedback(int attempts) {
        if (attempts == 1) {
            System.out.println("🏆 INCREDIBLE! First try! You're a mind reader!");
        } else if (attempts <= 2) {
            System.out.println("🥇 EXCELLENT! Amazing guessing skills!");
        } else if (attempts <= 4) {
            System.out.println("🥈 GREAT! Well done!");
        } else if (attempts <= 6) {
            System.out.println("🥉 GOOD! Nice job!");
        } else {
            System.out.println("✅ You made it! That was close!");
        }
    }
    
    /**
     * Asks player if they want to play again
     */
    private static boolean askPlayAgain() {
        System.out.print("\nDo you want to play again? (y/n): ");
        char choice = scanner.next().toLowerCase().charAt(0);
        return choice == 'y';
    }
    
    /**
     * Displays current game statistics
     */
    private static void displayCurrentStats() {
        System.out.println("\n=== Current Stats ===");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Games Won: " + gamesWon);
        if (gamesPlayed > 0) {
            double winRate = (double) gamesWon / gamesPlayed * 100;
            System.out.printf("Win Rate: %.1f%%\n", winRate);
        }
    }
    
    /**
     * Displays final game statistics
     */
    private static void displayFinalStats() {
        System.out.println("\n=== Final Game Statistics ===");
        System.out.println("Total Games Played: " + gamesPlayed);
        System.out.println("Total Games Won: " + gamesWon);
        System.out.println("Total Games Lost: " + (gamesPlayed - gamesWon));
        
        if (gamesPlayed > 0) {
            double winRate = (double) gamesWon / gamesPlayed * 100;
            System.out.printf("Final Win Rate: %.1f%%\n", winRate);
            
            if (winRate >= 80) {
                System.out.println("🌟 Outstanding performance! You're a guessing master!");
            } else if (winRate >= 60) {
                System.out.println("👍 Great job! You have good guessing skills!");
            } else if (winRate >= 40) {
                System.out.println("👌 Not bad! Keep practicing!");
            } else {
                System.out.println("💪 Keep trying! You'll get better with practice!");
            }
        }
    }
}