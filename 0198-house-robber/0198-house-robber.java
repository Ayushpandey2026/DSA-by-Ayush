class Solution {
    public int amount(int[] dp,int[] nums,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + amount(dp,nums,i+2);
        int skip =amount(dp,nums,i+1);
        return dp[i]= Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return amount(dp,nums,0);
    }
}