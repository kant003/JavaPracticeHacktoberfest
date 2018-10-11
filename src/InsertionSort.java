
/**
 * Implementation of insertion sort in Java
 *
 * @author sabio
 */
public class InsertionSort {

	public static void sort(int[] array) {
		for (int i = 1; i < array.length; ++i) {
			int x = array[i];
			int j = i-1;

			while (j >= 0 && array[j] > x) {
				array[j + 1] = array[j];
				j = j-1;
			}
			array[j + 1] = x;
		}

	}

	public static void main(String[] args) {
		int[] array = {23, 5, 34, 99, 1, 3};
		sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}

