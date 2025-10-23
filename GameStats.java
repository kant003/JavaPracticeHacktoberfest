/**
 * Game Statistics and Utilities for Number Guessing Game
 * Author: GitHub Copilot
 * Description: Helper class for game statistics and utility functions
 */
public class GameStats {
    
    // Difficulty levels
    public enum Difficulty {
        EASY(1, 50, 10),      // 1-50, 10 attempts
        MEDIUM(1, 100, 7),    // 1-100, 7 attempts  
        HARD(1, 200, 5),      // 1-200, 5 attempts
        EXPERT(1, 500, 8);    // 1-500, 8 attempts
        
        private final int minNumber;
        private final int maxNumber;
        private final int maxAttempts;
        
        Difficulty(int minNumber, int maxNumber, int maxAttempts) {
            this.minNumber = minNumber;
            this.maxNumber = maxNumber;
            this.maxAttempts = maxAttempts;
        }
        
        public int getMinNumber() { return minNumber; }
        public int getMaxNumber() { return maxNumber; }
        public int getMaxAttempts() { return maxAttempts; }
        public int getRange() { return maxNumber - minNumber + 1; }
    }
    
    /**
     * Calculates the theoretical minimum attempts needed using binary search
     * @param range The range of numbers (max - min + 1)
     * @return Minimum attempts needed
     */
    public static int calculateMinimumAttempts(int range) {
        if (range <= 0) return 0;
        return (int) Math.ceil(Math.log(range) / Math.log(2));
    }
    
    /**
     * Calculates a score based on attempts used and difficulty
     * @param attempts Number of attempts used
     * @param maxAttempts Maximum attempts allowed
     * @param range Range of numbers
     * @return Score from 0 to 1000
     */
    public static int calculateScore(int attempts, int maxAttempts, int range) {
        if (attempts > maxAttempts) return 0;
        
        // Base score for winning
        double baseScore = 500;
        
        // Bonus for fewer attempts (max 300 points)
        double efficiencyBonus = ((double)(maxAttempts - attempts) / maxAttempts) * 300;
        
        // Bonus for difficulty (max 200 points)
        double difficultyBonus = Math.min(200, range / 5.0);
        
        return (int) Math.round(baseScore + efficiencyBonus + difficultyBonus);
    }
    
    /**
     * Gets performance rating based on attempts and maximum attempts
     * @param attempts Attempts used
     * @param maxAttempts Maximum attempts allowed
     * @return Performance rating string
     */
    public static String getPerformanceRating(int attempts, int maxAttempts) {
        double efficiency = (double) attempts / maxAttempts;
        
        if (efficiency <= 0.2) {
            return "LEGENDARY";
        } else if (efficiency <= 0.4) {
            return "EXCELLENT";
        } else if (efficiency <= 0.6) {
            return "GOOD";
        } else if (efficiency <= 0.8) {
            return "FAIR";
        } else {
            return "LUCKY";
        }
    }
    
    /**
     * Generates helpful tips for the player
     * @param gamesPlayed Number of games played
     * @param winRate Win rate percentage
     * @return Array of tips
     */
    public static String[] generateTips(int gamesPlayed, double winRate) {
        if (gamesPlayed < 3) {
            return new String[]{
                "💡 Use binary search strategy: start with the middle number!",
                "💡 Pay attention to 'hot' and 'cold' hints!",
                "💡 Keep track of your previous guesses mentally."
            };
        } else if (winRate < 50) {
            return new String[]{
                "💡 Try the binary search method: always guess the middle of remaining range!",
                "💡 If the range is 1-100, start with 50, then 25 or 75 based on feedback.",
                "💡 Don't make random guesses - be systematic!"
            };
        } else {
            return new String[]{
                "💡 You're doing great! Try to win in fewer attempts for higher scores!",
                "💡 Challenge yourself with harder difficulty levels!",
                "💡 Aim for the theoretical minimum attempts when possible."
            };
        }
    }
    
    /**
     * Validates if a number is within the given range
     * @param number The number to validate
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return true if valid, false otherwise
     */
    public static boolean isValidGuess(int number, int min, int max) {
        return number >= min && number <= max;
    }
    
    /**
     * Calculates the optimal next guess using binary search strategy
     * @param low Current lower bound
     * @param high Current upper bound
     * @return Optimal next guess
     */
    public static int getOptimalGuess(int low, int high) {
        return low + (high - low) / 2;
    }
    
    /**
     * Formats game statistics into a readable string
     * @param gamesPlayed Total games played
     * @param gamesWon Total games won
     * @param totalScore Total score accumulated
     * @return Formatted statistics string
     */
    public static String formatStatistics(int gamesPlayed, int gamesWon, int totalScore) {
        if (gamesPlayed == 0) {
            return "No games played yet!";
        }
        
        double winRate = (double) gamesWon / gamesPlayed * 100;
        double averageScore = (double) totalScore / gamesPlayed;
        
        return String.format(
            "Games: %d | Wins: %d | Win Rate: %.1f%% | Avg Score: %.0f",
            gamesPlayed, gamesWon, winRate, averageScore
        );
    }
}