// Heap Sort Algorithm in Java
// Time Complexity: O(n log n)
// Builds a max heap and repeatedly extracts the largest element.

public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};
        sort(data);
        for (int num : data)
            System.out.print(num + " ");
    }
}
