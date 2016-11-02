public class BubbleSort {

	private static void sort(int[] a) {
		int length = a.length;

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					//Swap positions
					int k = a[i];
					a[i] = a[j];
					a[j] = k;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 65, 100, 4, 0, -1 };

		sort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
