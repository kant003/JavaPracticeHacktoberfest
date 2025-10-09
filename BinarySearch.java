/**
 * Binary Search Implementation in Java
 *
 * This class demonstrates the binary search algorithm which is an efficient
 * way to search for an element in a sorted array with O(log n) time complexity.
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class BinarySearch {

    /**
     * Performs binary search on a sorted array
     *
     * @param arr The sorted array to search in
     * @param target The element to search for
     * @return The index of the target element, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Calculate middle index to avoid integer overflow
            int mid = left + (right - left) / 2;

            // If target is found at mid, return the index
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Element not found
        return -1;
    }

    /**
     * Recursive implementation of binary search
     *
     * @param arr The sorted array to search in
     * @param left Starting index
     * @param right Ending index
     * @param target The element to search for
     * @return The index of the target element, or -1 if not found
     */
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // If target is found at mid, return the index
            if (arr[mid] == target) {
                return mid;
            }

            // If target is smaller, search left half
            if (arr[mid] > target) {
                return binarySearchRecursive(arr, left, mid - 1, target);
            }

            // If target is greater, search right half
            return binarySearchRecursive(arr, mid + 1, right, target);
        }

        // Element not found
        return -1;
    }

    /**
     * Main method to demonstrate binary search functionality
     */
    public static void main(String[] args) {
        // Example sorted array
        int[] sortedArray = {2, 3, 4, 10, 40, 50, 80, 100};
        int target = 10;

        System.out.println("Binary Search Demo");
        System.out.println("Array: [2, 3, 4, 10, 40, 50, 80, 100]");
        System.out.println("Target: " + target);

        // Test iterative binary search
        int result = binarySearch(sortedArray, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array");
        }

        // Test recursive binary search
        int recursiveResult = binarySearchRecursive(sortedArray, 0, sortedArray.length - 1, target);
        System.out.println("Recursive search result: " +
                         (recursiveResult != -1 ? "Found at index " + recursiveResult : "Not found"));

        // Test with element not in array
        int notFound = binarySearch(sortedArray, 25);
        System.out.println("Searching for 25: " +
                         (notFound != -1 ? "Found at index " + notFound : "Not found"));
    }
}