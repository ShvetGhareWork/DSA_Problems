class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int isAnIsland = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    isAnIsland++;
                    dfs(i, j, grid);
                }
            }
        }

        return isAnIsland;
    }

    private void dfs(int right, int left, char[][] grid){
        if(right < 0 || right >= grid.length || left < 0 || left >= grid[0].length || grid[right][left] == '0') return;

        grid[right][left] = '0';
        dfs(right + 1, left, grid);
        dfs(right - 1, left, grid);
        dfs(right, left + 1, grid);
        dfs(right, left - 1, grid);
    }
}