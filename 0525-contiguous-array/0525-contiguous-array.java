class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        int maxLen = 0;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += (nums[i] == 1) ? 1 : -1;
            
            if (map.containsKey(runningSum)) {
                maxLen = Math.max(maxLen, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return maxLen;
    }
}