/**
 * Test class for BinarySearch implementation
 *
 * This class contains test cases to verify the correctness of both
 * iterative and recursive binary search implementations.
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class BinarySearchTest {

    /**
     * Simple test method to verify binary search functionality
     */
    public static void runTests() {
        System.out.println("Running Binary Search Tests...\n");

        // Test case 1: Element exists in the array
        int[] testArray1 = {1, 3, 5, 7, 9, 11, 13, 15};
        int target1 = 7;
        int expected1 = 3;
        int result1 = BinarySearch.binarySearch(testArray1, target1);

        System.out.println("Test 1 - Element exists:");
        System.out.println("Array: [1, 3, 5, 7, 9, 11, 13, 15]");
        System.out.println("Target: " + target1);
        System.out.println("Expected: " + expected1 + ", Got: " + result1);
        System.out.println("Status: " + (result1 == expected1 ? "PASS" : "FAIL"));
        System.out.println();

        // Test case 2: Element does not exist
        int target2 = 6;
        int expected2 = -1;
        int result2 = BinarySearch.binarySearch(testArray1, target2);

        System.out.println("Test 2 - Element does not exist:");
        System.out.println("Target: " + target2);
        System.out.println("Expected: " + expected2 + ", Got: " + result2);
        System.out.println("Status: " + (result2 == expected2 ? "PASS" : "FAIL"));
        System.out.println();

        // Test case 3: First element
        int target3 = 1;
        int expected3 = 0;
        int result3 = BinarySearch.binarySearch(testArray1, target3);

        System.out.println("Test 3 - First element:");
        System.out.println("Target: " + target3);
        System.out.println("Expected: " + expected3 + ", Got: " + result3);
        System.out.println("Status: " + (result3 == expected3 ? "PASS" : "FAIL"));
        System.out.println();

        // Test case 4: Last element
        int target4 = 15;
        int expected4 = 7;
        int result4 = BinarySearch.binarySearch(testArray1, target4);

        System.out.println("Test 4 - Last element:");
        System.out.println("Target: " + target4);
        System.out.println("Expected: " + expected4 + ", Got: " + result4);
        System.out.println("Status: " + (result4 == expected4 ? "PASS" : "FAIL"));
        System.out.println();

        // Test recursive implementation
        int recursiveResult = BinarySearch.binarySearchRecursive(testArray1, 0, testArray1.length - 1, target1);
        System.out.println("Test 5 - Recursive implementation:");
        System.out.println("Target: " + target1);
        System.out.println("Expected: " + expected1 + ", Got: " + recursiveResult);
        System.out.println("Status: " + (recursiveResult == expected1 ? "PASS" : "FAIL"));
    }

    /**
     * Main method to run all tests
     */
    public static void main(String[] args) {
        runTests();
    }
}