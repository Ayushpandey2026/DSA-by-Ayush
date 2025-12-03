class Solution {
    public int count(int[] coins,int i, int amount, int[][] dp,int sum){
        if(sum==amount) return 1;
        if(i==coins.length  ) return 0;

        if(dp[i][sum]!=-1) return dp[i][sum];
        int skip =count(coins,i+1,amount,dp,sum);
        int pick =0;

        if(sum + coins[i]<=amount){
         pick =count(coins,i,amount,dp,sum + coins[i]);
        }

        return dp[i][sum] = skip + pick;
    }
    public int change(int amount,int[] coins) {
        int[][] dp =new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
       int ans= count(coins,0,amount,dp,0);
       return ans;
    }
}