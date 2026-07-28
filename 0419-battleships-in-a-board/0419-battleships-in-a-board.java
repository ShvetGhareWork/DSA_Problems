class Solution {
    public int countBattleships(char[][] board) {
        

        int m = board.length;
        int n = board[0].length;
        int battleships = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    battleships++;
                    dfs(board, i, j);
                }
            }
        }

        return battleships;
    }

    private void dfs(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'X') return;

        board[x][y] = '.';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}