class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = matrix[n - 1].clone();

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                int down = prev[j];
                int left = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? prev[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }

            prev = curr;
        }

        return Arrays.stream(prev).min().getAsInt();
    }
}
