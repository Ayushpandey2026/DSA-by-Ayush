// class Solution {
//     private boolean isvalid(char[][] board, int i, int j, char c){
//         int n = board.length;
//         for(int a=i;a<n;a++){
//             if(board[a][j]==c) return false;
//              if(board[i][a]==c) return false;
//         }
       
//           int startRow = 3 * (i / 3);
//     int startCol = 3 * (j / 3);

//     for (int r = startRow; r < startRow + 3; r++) {
//         for (int c1 = startCol; c1 < startCol + 3; c1++) {
//             if (board[r][c1] == c) return false; 
//         }
//     }
//     return true;
//     }
//     private boolean solver(char[][] board){
//         int n = board.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(board[i][j]=='.'){
//                     for(char c='1';c<='9';c++){
//                         if(isvalid(board,i,j,c)){
//                             board[i][j]=c;
//                             if(solver(board)) return true;
//                             else board[i][j]='.';
//                         }
//                     }
//                         return false;
//                     }
//                 }
//             }
//         return true;
//     }
//     public void solveSudoku(char[][] board) {
//         solver(board);
//     }
// }


class Solution {
    private boolean isValid(char[][] board, int i, int j, char c) {
        int n = board.length;

        for (int a = 0; a < n; a++) {
            if (board[a][j] == c) return false;
            if (board[i][a] == c) return false;
        }

        int startRow = 3 * (i / 3);
        int startCol = 3 * (j / 3);

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c1 = startCol; c1 < startCol + 3; c1++) {
                if (board[r][c1] == c) return false;
            }
        }

        return true;
    }

    private boolean solver(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solver(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    public void solveSudoku(char[][] board) {
        solver(board);
    }
}
