class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    virusSpread(grid, i , j, 2);
                }
            }
        }

        int minutes = 2;
        for(int[] row : grid){
            for(int num : row){
                if(num == 1) return -1;
                minutes = Math.max(num, minutes);
            }
        }

        return minutes - 2;
    }
    private void virusSpread(int[][] grid, int x, int y, int minutes){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || (1 < grid[x][y] && grid[x][y] < minutes))
            return;
        else
        grid[x][y] = minutes;
        virusSpread(grid, x + 1, y, minutes + 1);
        virusSpread(grid, x - 1, y, minutes + 1);
        virusSpread(grid, x, y + 1, minutes + 1);
        virusSpread(grid, x, y - 1, minutes + 1);
    }
}