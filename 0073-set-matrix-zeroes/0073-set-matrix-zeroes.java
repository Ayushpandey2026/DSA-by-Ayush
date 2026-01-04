class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
      boolean[][] flag = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) flag[i][j]=true; 
            }
        }
        int a=0,b=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(flag[i][j]==true){
                   for(int k=0;k<n;k++){
                        matrix[i][k]=0;
                    }
                      for(int k=0;k<m;k++){
                        matrix[k][j]=0;
                    }

                }
            }
        }
        
    }
}
