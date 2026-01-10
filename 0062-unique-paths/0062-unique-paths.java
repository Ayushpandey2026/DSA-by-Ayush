class Solution {
    public int paths(int m, int n, int i, int j,int[][] dp){
        // if(i>=m || j>=n) return 0;
        if(i==m-1 || j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
      int rw = paths(m,n,i+1,j,dp);
       int lw =  paths(m,n,i,j+1,dp);
       return dp[i][j]=  rw + lw;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] =-1;
            }
        }
        return paths(m,n,0,0,dp); 
    }
}