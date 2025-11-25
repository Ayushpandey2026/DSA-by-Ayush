class Solution {
    public int count(int[] coins,int i, int amount, int[][] dp){
        if(amount==0) return 0;
        if(i==coins.length || amount < 0) return (int)1e9;

        if(dp[i][amount]!=-1) return dp[i][amount];
        int skip =count(coins,i+1,amount,dp);
        int pick =1 + count(coins,i,amount-coins[i],dp);

       return  dp[i][amount] =Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp =new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       int ans= count(coins,0,amount,dp);
       return ans>=1e9 ? -1 : ans;
    }
}