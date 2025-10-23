// Insertion Sort Algorithm in Java
// Time Complexity: O(n^2)
// Builds the sorted array one item at a time by comparing and shifting elements.

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Element to be inserted
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {9, 5, 1, 4, 3};
        sort(data);
        for (int num : data)
            System.out.print(num + " ");
    }
}
