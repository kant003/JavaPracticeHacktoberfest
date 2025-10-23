import java.util.Scanner;

/**
 * Simple Calculator Application for Hacktoberfest
 * Author: GitHub Copilot
 * Description: A basic calculator that performs arithmetic operations
 */
public class SimpleCalculator {
    
    // Scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Main method to run the calculator
     */
    public static void main(String[] args) {
        System.out.println("=== Simple Calculator ===");
        System.out.println("Welcome to the Simple Calculator!");
        
        boolean continueCalculating = true;
        
        // Main calculator loop
        while (continueCalculating) {
            try {
                // Get first number from user
                System.out.print("\nEnter first number: ");
                double num1 = scanner.nextDouble();
                
                // Get operation from user
                System.out.print("Enter operation (+, -, *, /, %): ");
                char operation = scanner.next().charAt(0);
                
                // Get second number from user
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                // Perform calculation
                double result = performCalculation(num1, num2, operation);
                
                // Display result
                System.out.printf("Result: %.2f %c %.2f = %.2f%n", 
                    num1, operation, num2, result);
                
                // Ask if user wants to continue
                System.out.print("\nDo you want to perform another calculation? (y/n): ");
                char choice = scanner.next().charAt(0);
                continueCalculating = (choice == 'y' || choice == 'Y');
                
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        System.out.println("Thank you for using Simple Calculator!");
        scanner.close();
    }
    
    /**
     * Performs arithmetic calculation based on operation
     * @param num1 First number
     * @param num2 Second number
     * @param operation The operation to perform
     * @return Result of the calculation
     */
    private static double performCalculation(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return num1 / num2;
            case '%':
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot perform modulo by zero!");
                }
                return num1 % num2;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}