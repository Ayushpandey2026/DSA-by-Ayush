class Solution {
    public boolean isperfect(int n){
        int sqrt = (int)(Math.sqrt(n));
        return (sqrt*sqrt)==n;
    }
    public int cntSquares(int n, int[] dp) {
        if(isperfect(n)) return 1;
        if(dp[n]!=-1) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int cnt= cntSquares(i*i,dp) + cntSquares(n-i*i,dp);
            min = Math.min(min,cnt);
        }
        return dp[n]= min;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // for(int i=1;i<=n;i++){
        //     if(isperfect(i)) dp[i]= 1;
        //     else{
        //         int min = Integer.MAX_VALUE;
        //         for(int j=1;j*j<=i;j++){
        //             int cnt = dp[j*j] + dp[i-j*j];
        //             min=  Math.min(min,cnt);
        //         }
        //         dp[i]=min;
        //     }
        return cntSquares(n,dp);
        }
    //   return dp[n];
        
    
}