class Solution {
    public int mincost(int[] cost, int id, int[] dp){
        if(id ==0 || id==1) return cost[id];
        if(dp[id] !=-1) return dp[id];
        return dp[id] = cost[id] + Math.min(mincost(cost,id-1,dp),mincost(cost,id-2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
       return Math.min(mincost(cost,n-1,dp),mincost(cost,n-2,dp));
    }
}