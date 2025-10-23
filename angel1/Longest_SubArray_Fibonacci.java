class Longest_SubArray_Fibonacci {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int n = nums.length;

        if(n == 1 || n == 2) return n;

        int length = 2;

        for(int i = 2; i < n; i++){
            if(nums[i] == nums[i-1] + nums[i-2]){
                length += 1;
                count = Math.max(count, length);
            }
            else length = 2;
        }

        return count == 0 ? 2 : count;
    }
}