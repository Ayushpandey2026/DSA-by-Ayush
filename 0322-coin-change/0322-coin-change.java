class Solution {

    public int makeup(int i, int[] coins, int amount,int[][] dp){
        if(amount==0) return 0;
        if(i==coins.length || amount<0) return (int) 1e9;

        if(dp[i][amount]!=-1) return dp[i][amount];

        int take= 1 + makeup(i,coins,amount-coins[i],dp);
        int skip= makeup(i+1, coins,amount,dp);

        return dp[i][amount]=Math.min(take,skip);
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        int[][] dp =new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= makeup(0,coins,amount,dp);
      return ans>=1e9 ? -1 : ans;
    }
}