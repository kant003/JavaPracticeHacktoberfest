/**
 * Array Utilities
 * ================
 * A collection of useful array manipulation and analysis methods.
 * Provides common operations for working with integer arrays.
 * 
 * Features:
 * - Find min/max values
 * - Calculate sum and average
 * - Reverse and sort arrays
 * - Search for elements
 * - Display array contents
 * 
 * Author: Hacktoberfest 2025 Contributor
 * Date: October 20, 2025
 */

public class ArrayUtilities {
    
    /**
     * Finds the minimum value in an array
     * 
     * @param arr The input array
     * @return The minimum value, or Integer.MAX_VALUE if array is empty
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Finds the maximum value in an array
     * 
     * @param arr The input array
     * @return The maximum value, or Integer.MIN_VALUE if array is empty
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Calculates the sum of all elements in an array
     * 
     * @param arr The input array
     * @return The sum of all elements
     */
    public static int calculateSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    /**
     * Calculates the average of all elements in an array
     * 
     * @param arr The input array
     * @return The average as a double, or 0.0 if array is empty
     */
    public static double calculateAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        
        return (double) calculateSum(arr) / arr.length;
    }
    
    /**
     * Reverses an array in place
     * 
     * @param arr The array to reverse
     */
    public static void reverseArray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    /**
     * Searches for an element in an array
     * 
     * @param arr The array to search
     * @param target The element to find
     * @return The index of the element, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks if an array contains a specific element
     * 
     * @param arr The array to search
     * @param target The element to find
     * @return true if element exists, false otherwise
     */
    public static boolean contains(int[] arr, int target) {
        return linearSearch(arr, target) != -1;
    }
    
    /**
     * Sorts an array using bubble sort algorithm
     * 
     * @param arr The array to sort
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped;
        
        // Bubble sort with optimization
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Creates a copy of an array
     * 
     * @param arr The array to copy
     * @return A new array with the same elements
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    
    /**
     * Displays array contents in a formatted way
     * 
     * @param arr The array to display
     * @param label Optional label for the array
     */
    public static void printArray(int[] arr, String label) {
        if (label != null && !label.isEmpty()) {
            System.out.print(label + ": ");
        }
        
        if (arr == null) {
            System.out.println("null");
            return;
        }
        
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Main method - demonstrates array utility functions
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("ARRAY UTILITIES - Hacktoberfest 2025");
        System.out.println("=".repeat(60));
        
        // Test array
        int[] numbers = {42, 15, 8, 23, 4, 16, 37, 11};
        
        System.out.println("\n📊 Original Array:");
        printArray(numbers, "Numbers");
        
        // Statistical operations
        System.out.println("\n📈 Statistical Analysis:");
        System.out.println("─".repeat(40));
        System.out.println("Minimum value:  " + findMin(numbers));
        System.out.println("Maximum value:  " + findMax(numbers));
        System.out.println("Sum:            " + calculateSum(numbers));
        System.out.printf("Average:        %.2f%n", calculateAverage(numbers));
        System.out.println("─".repeat(40));
        
        // Search operations
        System.out.println("\n🔍 Search Operations:");
        System.out.println("─".repeat(40));
        int searchTarget = 23;
        int index = linearSearch(numbers, searchTarget);
        System.out.println("Search for " + searchTarget + ": " + 
                         (index != -1 ? "Found at index " + index : "Not found"));
        
        int missingTarget = 99;
        System.out.println("Search for " + missingTarget + ": " + 
                         (contains(numbers, missingTarget) ? "Found" : "Not found"));
        System.out.println("─".repeat(40));
        
        // Reverse operation
        System.out.println("\n🔄 Reverse Operation:");
        int[] reversedCopy = copyArray(numbers);
        reverseArray(reversedCopy);
        printArray(numbers, "Original ");
        printArray(reversedCopy, "Reversed ");
        
        // Sort operation
        System.out.println("\n⬆️  Sort Operation:");
        int[] sortedCopy = copyArray(numbers);
        bubbleSort(sortedCopy);
        printArray(numbers, "Original");
        printArray(sortedCopy, "Sorted  ");
        
        // Combined operations example
        System.out.println("\n🎯 Combined Operations Example:");
        System.out.println("─".repeat(40));
        int[] data = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        printArray(data, "Original data");
        
        bubbleSort(data);
        printArray(data, "After sorting");
        
        reverseArray(data);
        printArray(data, "After reversing");
        
        System.out.println("Min: " + findMin(data) + ", Max: " + findMax(data));
        System.out.println("─".repeat(40));
        
        // Usage examples
        System.out.println("\n\n💡 Usage Examples:");
        System.out.println("=".repeat(60));
        System.out.println("\n// Find minimum value:");
        System.out.println("int min = ArrayUtilities.findMin(myArray);");
        
        System.out.println("\n// Calculate average:");
        System.out.println("double avg = ArrayUtilities.calculateAverage(myArray);");
        
        System.out.println("\n// Sort an array:");
        System.out.println("ArrayUtilities.bubbleSort(myArray);");
        
        System.out.println("\n// Search for element:");
        System.out.println("int index = ArrayUtilities.linearSearch(myArray, 42);");
        
        System.out.println("\n// Reverse an array:");
        System.out.println("ArrayUtilities.reverseArray(myArray);");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ Array Utilities Ready!");
        System.out.println("=".repeat(60));
    }
}
