public class Merge_Sorting {
        // Function to print the array
        public static void print(int[] arr){
            for(int ele: arr){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        public static void merge_two_arrays(int[] a, int[]b, int[] res){
            int i = 0, j = 0, k = 0;
            while(i<a.length && j<b.length){
                if(a[i]>b[j]) res[k++] = b[j++];
                else res[k++] = a[i++];
            }
            if(i==a.length){
                while(j<b.length){
                    res[k++] = b[j++];
                }
            }
            if(j==b.length){
                while(i<a.length){
                    res[k++] = a[i++];
                }
            }
        }
        public static void mergeSortFunction(int[] arr){
            int n = arr.length;
            if(n==1) return;                 // Base Case
            // 1) Create 2 arrays of n/2 length
            int[] a = new int[n/2];          // 80,30,50,20
            int[] b = new int[n-n/2];        // 60,10,70,40
            // 2) Copy Pasting
            for(int i=0;i<n/2;i++){
                a[i] = arr[i];
            }
            for(int i=0;i<n-n/2;i++){
                b[i] = arr[i+n/2];
            }
            // 3) Magic (Apply Recursion)
            mergeSortFunction(a);
            mergeSortFunction(b);
            // 4) Merge these 'a' and 'b'
            merge_two_arrays(a,b,arr);
        }
        public static void main(String[] args) {
            int[] arr = {80,30,50,20,60,10,70,40};
            print(arr);
            mergeSortFunction(arr);
            print(arr);
        }

}
