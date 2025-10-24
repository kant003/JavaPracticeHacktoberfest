// 🧠 Explanation:

// This program implements Goldbach’s conjecture, which states that every even number greater than 2 can be expressed as the sum of two prime numbers.

// It validates that the user’s input:

// Is between 10 and 49, and

// Is even.

// Then it finds all possible prime pairs that add up to the entered number.


import java.util.Scanner; // Importing Scanner class to take input from user

public class Goldbach 
{
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in); // Creating Scanner object to read user input

        System.out.print("Enter a number: "); // Asking user to enter a number
        int number = scanner.nextInt(); // Reading the number entered by the user

        // Checking if the number is within the valid range (10 to 49)
        if (number <= 9 || number >= 50) 
        {
            System.out.println("INVALID INPUT. NUMBER OUT OF RANGE."); // Display error if not in range
            return; // Exit the program
        }

        // Checking if the number is even (Goldbach’s conjecture applies only to even numbers)
        if (number % 2 != 0)
        {
            System.out.println("INVALID INPUT. NUMBER IS ODD."); // Display error if number is odd
            return; // Exit the program
        }

        System.out.println("Prime pairs are:"); // Message to indicate start of prime pair list

        int first = 3; // Start checking from the first odd prime number
        int second = 0; // Variable to store the second number of the pair

        // Loop runs until 'first' is less than or equal to half of the number
        // (since pairs repeat after that)
        while (first <= number / 2) 
        {
            second = number - first; // Calculate the second number of the pair

            int count1 = 0, count2 = 0; // Counters to check if both numbers are prime

            // Check if 'first' is a prime number
            for (int i = 1; i <= first; i++)
            {
                if (first % i == 0) count1++; // Count divisors of 'first'
            }

            // Check if 'second' is a prime number
            for (int i = 1; i <= second; i++) 
            {
                if (second % i == 0) count2++; // Count divisors of 'second'
            }

            // If both numbers have exactly 2 divisors (1 and itself), they are prime
            if (count1 == 2 && count2 == 2) 
            {
                System.out.println(first + ", " + second); // Print the prime pair
            }

            first += 2; // Increment 'first' by 2 to check next odd number (since even numbers >2 are not prime)
        }
    }
}
