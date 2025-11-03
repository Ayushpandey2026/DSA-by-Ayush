class Solution {
    public int climb(int[] cost,int[] dp,int n){
        if(n==0 || n==1) return cost[n];
        if(dp[n]!=-1) return dp[n];
        return dp[n] = cost[n] + Math.min(climb(cost,dp,n-1),climb(cost,dp,n-2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(climb(cost,dp,n-1),climb(cost,dp,n-2));
    }
}