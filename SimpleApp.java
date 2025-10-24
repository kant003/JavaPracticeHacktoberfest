import java.util.Scanner;

public class SimpleApp {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask for user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Ask for user's age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Display a greeting message
        System.out.println("\nHello, " + name + "!");
        System.out.println("You are " + age + " years old.");

        // A simple conditional example
        if (age < 18) {
            System.out.println("You are a minor.");
        } else {
            System.out.println("You are an adult.");
        }

        // Close the scanner to avoid memory leak
        scanner.close();
    }
}
