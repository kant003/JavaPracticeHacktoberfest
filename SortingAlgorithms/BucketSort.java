// Bucket Sort Algorithm in Java
// Time Complexity: O(n + k)
// Works best for uniformly distributed data between 0 and 1.

import java.util.*;

public class BucketSort {
    public static void sort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        // Create empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new Vector<>();

        // Add elements into different buckets
        for (float value : arr) {
            int index = (int) (value * n);
            buckets[index].add(value);
        }

        // Sort individual buckets
        for (Vector<Float> bucket : buckets)
            Collections.sort(bucket);

        // Concatenate all buckets into arr[]
        int index = 0;
        for (Vector<Float> bucket : buckets)
            for (float value : bucket)
                arr[index++] = value;
    }

    public static void main(String[] args) {
        float[] data = {(float) 0.897, (float) 0.565, (float) 0.656,
                        (float) 0.123, (float) 0.665, (float) 0.343};
        sort(data);
        for (float num : data)
            System.out.print(num + " ");
    }
}
