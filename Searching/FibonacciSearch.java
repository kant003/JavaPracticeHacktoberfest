/**
 * Fibonacci Search Implementation in Java
 *
 * This class demonstrates the Fibonacci Search algorithm, an efficient
 * searching technique for sorted arrays that uses Fibonacci numbers to
 * divide the search space. The algorithm runs in O(log n) time.
 *
 * @author mtsagkl
 */
public class FibonacciSearch {
    /**
     * Executes the Fibonacci Search algorithm on a sorted array.
     * This method uses Fibonacci numbers to split the search range .
     *
     * @param arr the sorted array in which the search is performed
     * @param n   the array's size
     * @param key the element to search for
     * @return    the index of the key if found, otherwise -1
     */
    static int fibonacci_search(int arr[], int n,int key ){
        int offset =-1;
        int fm2=0;
        int fm1=1;
        int fm=fm1+fm2;

        // find smallest Fibonacci number >= n
        while(fm<n){
            fm2=fm1;
            fm1=fm;
            fm=fm2+fm1;
        }

        while (fm>1){
            int i;
            if (offset+fm2<n-1){
                i=offset+fm2;
            }
            else
                i=n-1;

            // if value is smaller, move right
            if(arr[i]<key){
                fm=fm1;
                fm1=fm2;
                fm2=fm-fm1;
                offset=i;
            }
            // if value is greater, move left
            else if(arr[i]>key){
                fm=fm2;
                fm1=fm1-fm2;
                fm2=fm-fm1;
            }
            // value found
            else
                return i;
        }
        // check last possible position
        if (fm1==1 && arr[offset+1]==key)
            return offset +1;
        return -1;  // not found
    }

    /**
     * Main method to demonstrate Fibonacci search functionality
     */
    public static void main(String[] args) {
        int n , key;
        int arr[]={-15,-5,2,5,7,10,28,30,45,56};
        System.out.print("Array's elements: ");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        n = arr.length;

        // Test with element in array
        key = 10;
        System.out.println("\nThe element to be searched: " + key);
        int index = fibonacci_search(arr, n, key);
        if(index >= 0)
            System.out.println("Found at index " + index);
        else
            System.out.println("Not found");

        // Test with element not in array
        key = 20;
        System.out.println("The element to be searched: " + key);
        index = fibonacci_search(arr, n, key);
        if(index >= 0)
            System.out.println("Found at index " + index);
        else
            System.out.println("Not found");
    }
}
