class Solution {
    public int amount(int[] dp,int[] nums,int i,int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + amount(dp,nums,i+2,n);
        int skip =amount(dp,nums,i+1,n);
        return dp[i]= Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        return Math.max(amount(dp,nums,1,n),amount(dp1,nums,0,n-1));
    }
}