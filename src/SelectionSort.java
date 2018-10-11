/**
 * Implementation of selection sort in Java
 *
 * @author sabio
 */
public class SelectionSort {

	/* Selection sort implementation */ 
	public static void sort(int[] array) {
		int ARRAY_LENGTH = array.length;

		for(int i=0; i<ARRAY_LENGTH-1; i++){		
			int lowest_index = i;
			for(int j = i+1; j<ARRAY_LENGTH; j++) if(array[j] < array[lowest_index]) lowest_index = j;

			if (lowest_index != i){
				int tmp = array[lowest_index];
				array[lowest_index] = array[i];
				array[i] = tmp;
			}
		}
		
		
	}
	
	/* Main method */
	public static void main(String[] args) {
		int[] array = {23, 5, 34, 99, 1, 3};
		sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}

