class Solution {
    private int minimum(int[][] mat,int target,int i,int sum,int[][] dp){
        if(i==mat.length) return Math.abs(sum-target);
        
        if(dp[i][sum]!=-1) return dp[i][sum];
        int ans = Integer.MAX_VALUE;

        for(int val : mat[i]){
            ans = Math.min(ans,minimum(mat,target,i+1,sum+val,dp));
        }
        return dp[i][sum]=ans;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        int mxsum=70*70;
        int[][] dp =new int[m][mxsum+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
       return minimum(mat,target,0,0,dp);
    }
}