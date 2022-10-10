import java.util.*;

class Change{
static long countWaysToMakeChange(int[] arr, int n, int T){
    
    long[] prev=new long[T+1];
    for(int i=0;i<=T;i++){
        if(i%arr[0]==0)
            prev[i]=1;
    }
    
    for(int ind=1; ind<n;ind++){
        long cur[]=new long[T+1];
        for(int target=0;target<=T;target++){
            long notTaken = prev[target];
            
            long taken = 0;
            if(arr[ind]<=target)
                taken = cur[target-arr[ind]];
                
            cur[target] = notTaken + taken;
        }
        prev = cur;
    }
    
    return prev[T];
}

public static void main(String args[]) {

  int arr[] ={1,2,3};
  int target=4;
  
  int n =arr.length;
                                 
  System.out.println("The total number of ways is "+countWaysToMakeChange
  (arr,n,target));
}
}
