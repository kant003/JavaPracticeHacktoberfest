public class InterpolationSearch {
    /**
     * Performs Interpolation Search on a sorted array.
     *
     * @param arr Sorted array of integers
     * @param key Element to search
     * @return index of key if found, otherwise -1
     */
    public static int interpolationSearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {

            // Avoid division by zero
            if (arr[high] == arr[low]) {
                if (arr[low] == key) {
                    return low;
                } else {
                    return -1;
                }
            }

            // Estimate the position
            int pos = low + ((key - arr[low]) * (high - low))
                    / (arr[high] - arr[low]);

            if (arr[pos] == key) {
                return pos;
            }

            if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }
}
