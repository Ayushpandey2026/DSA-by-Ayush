class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] rowSum = new long[m][n + 1];
        long[][] colSum = new long[m + 1][n];
        long[][] d1Sum = new long[m + 1][n + 1];
        long[][] d2Sum = new long[m + 1][n + 1]; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
                d1Sum[i + 1][j + 1] = d1Sum[i][j] + grid[i][j];
                d2Sum[i + 1][j] = d2Sum[i][j + 1] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagic(grid, i, j, k, rowSum, colSum, d1Sum, d2Sum)) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k, 
                            long[][] rs, long[][] cs, long[][] d1, long[][] d2) {
        
        long target = rs[r][c + k] - rs[r][c];

        for (int i = 1; i < k; i++) {
            if (rs[r + i][c + k] - rs[r + i][c] != target) return false;
        }

        for (int j = 0; j < k; j++) {
            if (cs[r + k][c + j] - cs[r][c + j] != target) return false;
        }

        if (d1[r + k][c + k] - d1[r][c] != target) return false;

        if (d2[r + k][c] - d2[r][c + k] != target) return false;

        return true;
    }
}