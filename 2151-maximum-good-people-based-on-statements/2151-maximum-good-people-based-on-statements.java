class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxGood = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (isValid(mask, statements, n)) {
                maxGood = Math.max(maxGood, Integer.bitCount(mask));
            }
        }
        return maxGood;
    }

    private boolean isValid(int mask, int[][] statements, int n) {
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                for (int j = 0; j < n; j++) {
                    int statement = statements[i][j];
                    if (statement == 2) continue; 
                    int statusOfJ = (mask >> j) & 1;
                    if (statement != statusOfJ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}