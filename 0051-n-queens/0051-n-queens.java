class Solution {
    static List<String> makestring(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
    private boolean isvalid(int row,int col,char[][] array){
        for(int i=0;i<row;i++){
            if(array[i][col]=='Q') return false;
        }
        int maxright = Math.min(row,array.length-1-col);
         for(int i=1;i<=maxright;i++){
            if(array[row-i][col+i]=='Q') return false;
        }
         int maxleft = Math.min(row,col);
         for(int i=1;i<=maxleft;i++){
            if(array[row-i][col-i]=='Q') return false;
        }
        return true;
    }

    private void queen(List<List<String>> ans,int row,int n,char[][] board){
        if(row==n){
            ans.add(makestring(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isvalid(row,col,board)){
                board[row][col]='Q';
                queen(ans,row+1,n,board);
                board[row][col]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] array = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            array[i][j]='.';
        }
    }
    List<List<String>>  ans = new ArrayList<>();
    queen(ans,0,n,array);
    return ans;
    }
}