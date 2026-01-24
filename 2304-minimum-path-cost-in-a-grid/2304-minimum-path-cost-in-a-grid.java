class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
         int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {

                int currVal = grid[i][j];

                for (int k = 0; k < n; k++) {
                    dp[i + 1][k] = Math.min(
                        dp[i + 1][k] == 0 ? Integer.MAX_VALUE : dp[i + 1][k],
                        dp[i][j] + moveCost[currVal][k] + grid[i + 1][k]
                    );
                }
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
}