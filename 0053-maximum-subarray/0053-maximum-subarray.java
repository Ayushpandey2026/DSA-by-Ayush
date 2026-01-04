class Solution {
    public int maxSubArray(int[] nums) {
        int curr= nums[0];
        int mac= nums[0];
        for(int i=1;i<nums.length;i++){
            curr = Math.max(nums[i],nums[i]+curr);
            mac= Math.max(mac,curr);
        }
        return mac;
    }
}