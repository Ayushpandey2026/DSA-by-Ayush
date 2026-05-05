class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp =new int[n+1];

        if(prices==null || prices.length==0) return 0;

         int minprice=prices[0];
         dp[0]=0;


        for(int i=1;i<n;i++){
            minprice =Math.min(prices[i],minprice);

            dp[i] = Math.max(dp[i-1],prices[i]-minprice);

        }
        return dp[n-1];
    }
}