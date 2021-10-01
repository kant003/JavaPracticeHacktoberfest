import java.util.Scanner;

public class test{

    private int interpolationSearch(int[] arr, int val){
        int low = 0, pos, high = arr.length - 1;
        while(low<=high){
            pos = low + ((val - arr[low])/(arr[high] - arr[low]));
            if(arr[pos]==val){
                return pos;
            }
            else if(arr[pos]>val){
                high = pos-1;
            }
            else{
                low = pos+1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        test t = new test();
        int[] arr = {3,7,8,10,45,1,89,24,56,100,4,34};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to be searched : ");
        int val = sc.nextInt();
        int ret = t.interpolationSearch(arr, val);
        if(ret==-1){
            System.out.println("Value not found!!");
        }
        else{
            System.out.println("Value found at position "+(ret+1));
        }
    }
}
