class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length; 
        long sum =0;
        for(int  i= 0;i<nums.length;i++){
             int max = nums[i];
            int min = nums[i];
            for(int j=i;j<n;j++){
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                sum +=(max-min);
            }
        }
        return sum;
    }
}