// Counting Sort Algorithm in Java
// Time Complexity: O(n + k) where k is range of input
// Works only for non-negative integers.

public class CountingSort {
    public static void sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];

        int[] count = new int[max + 1];

        // Store count of each element
        for (int i : arr)
            count[i]++;

        // Rebuild the array
        int index = 0;
        for (int i = 0; i <= max; i++)
            while (count[i]-- > 0)
                arr[index++] = i;
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        sort(data);
        for (int num : data)
            System.out.print(num + " ");
    }
}
