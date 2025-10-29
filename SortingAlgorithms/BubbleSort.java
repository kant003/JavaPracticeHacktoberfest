// Bubble Sort Algorithm in Java
// Time Complexity: O(n^2)
// Simple algorithm that repeatedly swaps adjacent elements if they are in wrong order.

public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if current element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 8, 4, 2};
        sort(data);
        for (int num : data)
            System.out.print(num + " ");
    }
}
