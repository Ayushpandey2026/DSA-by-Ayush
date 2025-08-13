class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char val = board[i][j];
                if(val =='.') continue;
                for(int k=0;k<9;k++){
                    if( val!=' ' &&  val==board[i][k] && k!=j) return false;
                }
                 for(int l=0;l<9;l++){
                    if(val==board[l][j] && l!=i) return false;
                }
                int r =(i/3)*3;
                 int c =(j/3)*3;
                 for(int x=r;x<r+3;x++){
                    for(int y=c;y<c+3;y++){
                       if(val==board[x][y] && (x!=i || y!=j) ) return false; 
                    }
                 }
            }
        }
        return true;
    }
}