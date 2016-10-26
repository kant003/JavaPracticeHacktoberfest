public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort instance = new InsertionSort();
		
		// List of Strings to be sorted
		String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter",
				"Saturn", "Uranus", "Neptune" };
		instance.insertionSort(planets);
		
		// Print the sorted list
		for (int i = 0; i < planets.length; i++) {
			System.out.print(planets[i] + " ");
		}
		
		System.out.println();
	}

	/*
		A simple sorting algorithm that builds the final sorted array one item at a time.
		It goes through each element and compares it with the previous elements and inserts
	    the element in the correct order.	
	*/
	public void insertionSort(String[] array) {
		String temp;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			int j = i;

			while ((j > 0) && (temp.compareTo(array[j - 1]) < 0)) {
				array[j] = array[j - 1];
				j--;

			}
			array[j] = temp;
		}
	}
}
