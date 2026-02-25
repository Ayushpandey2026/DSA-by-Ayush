class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int prevMax = 0;
        int i = 0;

        while (i < n) {
            int currentBitCount = Integer.bitCount(nums[i]);
            int currentMin = nums[i];
            int currentMax = nums[i];

            int j = i;
            while (j < n && Integer.bitCount(nums[j]) == currentBitCount) {
                currentMin = Math.min(currentMin, nums[j]);
                currentMax = Math.max(currentMax, nums[j]);
                j++;
            }

            if (currentMin < prevMax) {
                return false;
            }
            prevMax = currentMax;
            i = j;
        }
        return true;
    }
}