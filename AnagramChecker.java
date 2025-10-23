import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Anagram Checker!");
        System.out.print("Enter the first word: ");
        String first = scanner.nextLine();

        System.out.print("Enter the second word: ");
        String second = scanner.nextLine();

        if (areAnagrams(first, second)) {
            System.out.println("Yes \"" + first + "\" and \"" + second + "\" are anagrams!");
        } else {
            System.out.println("No \"" + first + "\" and \"" + second + "\" are NOT anagrams.");
        }

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        // If lengths differ, cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert to char arrays and sort
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
