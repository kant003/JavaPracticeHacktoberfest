// Importing the Scanner class to take input from the user
import java.util.Scanner;

// Main class
public class SimpleCalculator {

    // Main method: entry point of the program
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for two numbers
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Call the addNumbers method to add the two numbers
        int sum = addNumbers(num1, num2);

        // Print the result
        System.out.println("The sum is: " + sum);

        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Method to add two numbers and return the result
    public static int addNumbers(int a, int b) {
        return a + b; // return the sum
    }
}
