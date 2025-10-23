/**
 * Sorting Algorithm Performance Benchmark
 *
 * This class provides comprehensive benchmarking tools to compare
 * the performance of different sorting algorithms on various data sets:
 * - Random data
 * - Already sorted data
 * - Reverse sorted data
 * - Data with duplicates
 *
 * Measures execution time and provides detailed analysis.
 *
 * @author Hacktoberfest Contributor
 * @version 1.0
 */
public class SortingBenchmark {

    /**
     * Enum to represent different data patterns for testing
     */
    public enum DataPattern {
        RANDOM,
        SORTED,
        REVERSE_SORTED,
        MOSTLY_SORTED,
        WITH_DUPLICATES
    }

    /**
     * Generates test data based on specified pattern
     *
     * @param size Size of the array to generate
     * @param pattern Type of data pattern
     * @return Generated array
     */
    public static int[] generateTestData(int size, DataPattern pattern) {
        int[] arr = new int[size];

        switch (pattern) {
            case RANDOM:
                for (int i = 0; i < size; i++) {
                    arr[i] = (int) (Math.random() * 1000);
                }
                break;

            case SORTED:
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                break;

            case REVERSE_SORTED:
                for (int i = 0; i < size; i++) {
                    arr[i] = size - i;
                }
                break;

            case MOSTLY_SORTED:
                // Generate sorted array with 10% random swaps
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
                int swaps = size / 10;
                for (int i = 0; i < swaps; i++) {
                    int pos1 = (int) (Math.random() * size);
                    int pos2 = (int) (Math.random() * size);
                    swap(arr, pos1, pos2);
                }
                break;

            case WITH_DUPLICATES:
                // Generate array with many duplicate values
                for (int i = 0; i < size; i++) {
                    arr[i] = (int) (Math.random() * (size / 10)); // Many duplicates
                }
                break;
        }

        return arr;
    }

    /**
     * Benchmarks a sorting algorithm with given data
     *
     * @param arr Array to sort
     * @param algorithmName Name of the algorithm
     * @param algorithm Runnable that performs the sorting
     * @return Execution time in nanoseconds
     */
    public static long benchmarkSort(int[] arr, String algorithmName, Runnable algorithm) {
        // Verify array is not already sorted to ensure fair testing
        int[] testArray = copyArray(arr);

        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        // Verify the array is actually sorted
        if (!isSorted(testArray)) {
            System.out.println("WARNING: " + algorithmName + " did not sort the array correctly!");
        }

        return executionTime;
    }

    /**
     * Runs comprehensive performance tests on all algorithms
     *
     * @param sizes Array sizes to test
     */
    public static void runPerformanceTests(int[] sizes) {
        System.out.println("=== Sorting Algorithm Performance Benchmark ===\n");

        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);
            System.out.println("-".repeat(50));

            for (DataPattern pattern : DataPattern.values()) {
                System.out.println("\nData Pattern: " + pattern);

                // Generate test data
                int[] originalData = generateTestData(size, pattern);

                // Test each algorithm
                testMergeSort(originalData);
                testQuickSort(originalData);
                testHeapSort(originalData);

                // Only test counting sort for smaller datasets and appropriate data
                if (size <= 10000 && (pattern == DataPattern.RANDOM ||
                                    pattern == DataPattern.WITH_DUPLICATES)) {
                    testCountingSort(originalData);
                }

                System.out.println();
            }
            System.out.println("=".repeat(70));
        }
    }

    /**
     * Test Merge Sort performance
     */
    private static void testMergeSort(int[] originalData) {
        int[] testArray = copyArray(originalData);
        long time = benchmarkSort(testArray, "Merge Sort",
            () -> AdvancedSortingAlgorithms.mergeSort(testArray, 0, testArray.length - 1));
        System.out.printf("Merge Sort:    %10.2f ms\n", time / 1_000_000.0);
    }

    /**
     * Test Quick Sort performance
     */
    private static void testQuickSort(int[] originalData) {
        int[] testArray = copyArray(originalData);
        long time = benchmarkSort(testArray, "Quick Sort",
            () -> AdvancedSortingAlgorithms.quickSort(testArray, 0, testArray.length - 1));
        System.out.printf("Quick Sort:    %10.2f ms\n", time / 1_000_000.0);
    }

    /**
     * Test Heap Sort performance
     */
    private static void testHeapSort(int[] originalData) {
        int[] testArray = copyArray(originalData);
        long time = benchmarkSort(testArray, "Heap Sort",
            () -> AdvancedSortingAlgorithms.heapSort(testArray));
        System.out.printf("Heap Sort:     %10.2f ms\n", time / 1_000_000.0);
    }

    /**
     * Test Counting Sort performance
     */
    private static void testCountingSort(int[] originalData) {
        int[] testArray = copyArray(originalData);
        long time = benchmarkSort(testArray, "Counting Sort",
            () -> {
                int[] result = AdvancedSortingAlgorithms.countingSort(testArray);
                System.arraycopy(result, 0, testArray, 0, result.length);
            });
        System.out.printf("Counting Sort: %10.2f ms\n", time / 1_000_000.0);
    }

    /**
     * Utility method to check if array is sorted
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
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
     * Utility method to swap elements
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Demonstrates sorting algorithm analysis with recommendations
     */
    public static void showAlgorithmAnalysis() {
        System.out.println("\n=== Sorting Algorithm Analysis & Recommendations ===\n");

        System.out.println("1. MERGE SORT");
        System.out.println("   • Time: O(n log n) guaranteed (best, average, worst)");
        System.out.println("   • Space: O(n) - requires additional memory");
        System.out.println("   • Stable: Yes (maintains relative order of equal elements)");
        System.out.println("   • Best for: Large datasets, when stability is required");
        System.out.println();

        System.out.println("2. QUICK SORT");
        System.out.println("   • Time: O(n log n) average, O(n²) worst case");
        System.out.println("   • Space: O(log n) - in-place with recursion stack");
        System.out.println("   • Stable: No");
        System.out.println("   • Best for: General purpose, when average performance matters");
        System.out.println();

        System.out.println("3. HEAP SORT");
        System.out.println("   • Time: O(n log n) guaranteed (best, average, worst)");
        System.out.println("   • Space: O(1) - truly in-place");
        System.out.println("   • Stable: No");
        System.out.println("   • Best for: When memory is limited, worst-case guarantee needed");
        System.out.println();

        System.out.println("4. COUNTING SORT");
        System.out.println("   • Time: O(n + k) where k is the range of input");
        System.out.println("   • Space: O(k) - requires counting array");
        System.out.println("   • Stable: Yes");
        System.out.println("   • Best for: Small range of integers, when linear time is needed");
        System.out.println();
    }

    /**
     * Main method to run benchmarks
     */
    public static void main(String[] args) {
        // Test with different array sizes
        int[] testSizes = {1000, 5000, 10000};

        // Run performance tests
        runPerformanceTests(testSizes);

        // Show algorithm analysis
        showAlgorithmAnalysis();

        System.out.println("=== Benchmark Complete ===");
        System.out.println("\nNote: Performance may vary based on:");
        System.out.println("• Hardware specifications");
        System.out.println("• JVM optimizations");
        System.out.println("• System load");
        System.out.println("• Data characteristics");
    }
}