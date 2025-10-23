// Selection Sort Algorithm in Java
// Time Complexity: O(n^2)
// Finds the minimum element and places it at the beginning of the array.

public class SelectionSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Move boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 10, 14, 37, 13};
        sort(data);
        for (int num : data)
            System.out.print(num + " ");
    }
}
