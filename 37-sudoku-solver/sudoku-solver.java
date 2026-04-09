class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }
    private static boolean solveSudoku(char[][] board,int row,int col){
        if(row==9){
            return true;
        }
        if(col==9){
            return solveSudoku(board,row+1,0);
        }
        if(board[row][col]!='.'){
            return solveSudoku(board,row,col+1);
        }
        for(char num='1';num<='9';num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solveSudoku(board,row,col+1)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    private static boolean isSafe(char[][] board,int row,int col,char num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        int gridRow=(row/3)*3;
        int gridCol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[gridRow+i][gridCol+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}