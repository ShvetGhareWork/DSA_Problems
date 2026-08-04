class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    result = backtrack(board, word, i, j, 0, visited);
                    if(result) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char board[][], String word, int x ,int y, int index, boolean [][] visited){
        if(index == word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) return false;

        visited[x][y] = true;
        
        if(backtrack(board, word, x + 1, y, index + 1, visited) || 
           backtrack(board, word, x - 1, y, index + 1, visited) || 
           backtrack(board, word, x, y + 1, index + 1, visited) ||
           backtrack(board, word, x, y - 1, index + 1, visited)) return true;

        visited[x][y] = false;
        return false;
    }
}