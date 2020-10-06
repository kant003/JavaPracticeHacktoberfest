public class BubbleSort {

	private static void sort(int[] a) {
		int length = a.length;
    		boolean swap = false;

	    // Enhanced Bubble sort - Best Case Time-Complexity O(n)
	    do{
		      swap = false;

		      for(int i = 0 ; i < length - 1; i++){
				if (a[i] > a[i + 1]) {
					//Swap positions
					int k = a[i];
					a[i] = a[i + 1];
					a[i + 1] = k;

					//set swap to true
					swap = true;
				}
		      }
	      }while(swap);

	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 65, 100, 4, 0, -1 };

		sort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
