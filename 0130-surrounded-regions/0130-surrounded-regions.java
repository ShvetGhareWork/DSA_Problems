class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isBorder = (i == 0) || (i == rows - 1) || (j == 0) || (j == cols - 1);
                
                if(isBorder && board[i][j] == 'O'){
                    returnX(board, i, j);
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void returnX(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;

        board[x][y] = 'T';
        returnX(board, x + 1, y);
        returnX(board, x - 1, y);
        returnX(board, x, y + 1);
        returnX(board, x, y - 1);
    }
}