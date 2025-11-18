class Solution {
    public int paths(int m, int n, int i, int j,int[][] grid, int[][] dp){
        if(i>=m || j>=n) return 0;
         if(grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int rw = paths(m,n,i+1,j,grid,dp);
        int lw =  paths(m,n,i,j+1,grid,dp);
        return dp[i][j]=  rw + lw;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length;
       int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return paths(m,n,0,0,obstacleGrid,dp); 
    }
}

