/**
 * Calculator Helper Utilities
 * Author: GitHub Copilot
 * Description: Helper class with utility methods for mathematical operations
 */
public class CalculatorUtils {
    
    /**
     * Calculates the power of a number
     * @param base The base number
     * @param exponent The exponent
     * @return base raised to the power of exponent
     */
    public static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        
        double result = 1;
        int absExponent = Math.abs(exponent);
        
        // Calculate power using repeated multiplication
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        
        // Handle negative exponents
        return exponent < 0 ? 1.0 / result : result;
    }
    
    /**
     * Calculates the square root of a number
     * @param number The number to find square root of
     * @return Square root of the number
     */
    public static double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        if (number == 0) return 0;
        
        // Using Newton's method for square root approximation
        double x = number;
        double root = 0.5 * (x + (number / x));
        
        while (Math.abs(root - x) > 0.0001) {
            x = root;
            root = 0.5 * (x + (number / x));
        }
        
        return root;
    }
    
    /**
     * Calculates the factorial of a number
     * @param n The number to calculate factorial for
     * @return Factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n <= 1) return 1;
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Checks if a number is prime
     * @param number The number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        
        // Check for divisors from 5 to sqrt(number)
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}