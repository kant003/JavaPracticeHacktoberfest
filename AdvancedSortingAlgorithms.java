/**
 * Advanced Sorting Algorithms Collection
 *
 * This class implements various efficient sorting algorithms including:
 * - Merge Sort (O(n log n) time, O(n) space)
 * - Quick Sort (O(n log n) average, O(n²) worst case)
 * - Heap Sort (O(n log n) time, O(1) space)
 * - Counting Sort (O(n + k) time for integers)
 *
 * Each algorithm is thoroughly documented with time/space complexity analysis.
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class AdvancedSortingAlgorithms {

    /**
     * Merge Sort - Divide and Conquer Algorithm
     * Time Complexity: O(n log n) in all cases
     * Space Complexity: O(n) for temporary arrays
     *
     * @param arr Array to be sorted
     * @param left Starting index
     * @param right Ending index
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point to divide array into two halves
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Helper method to merge two sorted subarrays
     *
     * @param arr Main array
     * @param left Starting index of left subarray
     * @param mid Ending index of left subarray
     * @param right Ending index of right subarray
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for left and right subarrays
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArray, 0, leftArray.length);
        System.arraycopy(arr, mid + 1, rightArray, 0, rightArray.length);

        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }

    /**
     * Quick Sort - Partition-based Algorithm
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(log n) due to recursion stack
     *
     * @param arr Array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partition method for Quick Sort using last element as pivot
     *
     * @param arr Array to partition
     * @param low Starting index
     * @param high Ending index
     * @return Index of pivot after partitioning
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Place pivot in correct position
        return i + 1;
    }

    /**
     * Heap Sort - Tree-based sorting algorithm
     * Time Complexity: O(n log n) in all cases
     * Space Complexity: O(1) - sorts in place
     *
     * @param arr Array to be sorted
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Heapify a subtree rooted at given index
     *
     * @param arr Array representing the heap
     * @param n Size of heap
     * @param i Root index of subtree
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /**
     * Counting Sort - Non-comparison based sorting
     * Time Complexity: O(n + k) where k is the range of input
     * Space Complexity: O(k) for counting array
     *
     * @param arr Array to be sorted (assumes non-negative integers)
     * @return New sorted array
     */
    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) return arr;

        // Find the maximum element to determine range
        int max = findMax(arr);

        // Create counting array
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        // Count occurrences of each element
        for (int num : arr) {
            count[num]++;
        }

        // Transform count array to store actual positions
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build output array in reverse order to maintain stability
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }

    /**
     * Utility method to find maximum element in array
     */
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Utility method to swap two elements in array
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Utility method to print array
     */
    private static void printArray(int[] arr, String label) {
        System.out.print(label + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Utility method to copy array
     */
    private static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    /**
     * Main method to demonstrate all sorting algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Advanced Sorting Algorithms Demo ===\n");

        // Test data
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};

        System.out.println("Original Array:");
        printArray(originalArray, "Unsorted");
        System.out.println();

        // Test Merge Sort
        System.out.println("--- Merge Sort ---");
        int[] mergeArray = copyArray(originalArray);
        long startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long endTime = System.nanoTime();
        printArray(mergeArray, "Merge Sort Result");
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println();

        // Test Quick Sort
        System.out.println("--- Quick Sort ---");
        int[] quickArray = copyArray(originalArray);
        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        printArray(quickArray, "Quick Sort Result");
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println();

        // Test Heap Sort
        System.out.println("--- Heap Sort ---");
        int[] heapArray = copyArray(originalArray);
        startTime = System.nanoTime();
        heapSort(heapArray);
        endTime = System.nanoTime();
        printArray(heapArray, "Heap Sort Result");
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println();

        // Test Counting Sort
        System.out.println("--- Counting Sort ---");
        int[] countArray = copyArray(originalArray);
        startTime = System.nanoTime();
        int[] countResult = countingSort(countArray);
        endTime = System.nanoTime();
        printArray(countResult, "Counting Sort Result");
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        System.out.println("\n=== All algorithms completed successfully! ===");
    }
}