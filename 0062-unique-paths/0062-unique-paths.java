class Solution {
    public int uniquePaths(int m, int n) {
        int[][] a = new int[2][n];
        for(int i=0;i<n;i++){
            a[0][i]=1;
            a[1][i]=1;
        }
        for(int j=1;j<=m-1;j++){
            for(int i=1;i<n;i++){
                a[1][i]=a[1][i-1] + a[0][i];
            }
             for(int i=1;i<n;i++){
                a[0][i]=a[1][i];
            }

        }
        return a[1][n-1];
    }
}