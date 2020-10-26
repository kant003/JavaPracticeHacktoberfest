class Solution {
    public int[] shuffle(int[] nums, int n) {
        int result[]=new int[2*n];
        int temp = 1;
        for(int i = 0; i <2*n; i++)
        {
            if(i<n)
            {
                result[2*i] = nums[i];
            }
            else
            {
                result[i-n+temp] = nums[i];
                temp++;
            }
        }
        
        return result;
   }
}
