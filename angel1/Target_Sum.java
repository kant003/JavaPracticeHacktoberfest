class Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return findTarget(nums, target, 0, 0, map);
    }

    public int findTarget(int[] nums, int target, int i, int sum, Map<String, Integer> map){
        if(i == nums.length){
            return sum == target ? 1 : 0;
        }

        String key = i + "," + sum;

        if(map.containsKey(key)) return map.get(key);

        int count = findTarget(nums, target, i+1, sum + nums[i], map) +
                findTarget(nums, target, i+1, sum - nums[i], map);

        map.put(key, count);

        return map.get(key);
    }