class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && checkIsland(grid, i, j)){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean checkIsland(int[][] grid, int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;

        if(grid[x][y] == 1) return true;
        grid[x][y] = 1;

        boolean left = checkIsland(grid, x - 1, y);
        boolean right = checkIsland(grid, x + 1, y);
        boolean top = checkIsland(grid, x, y + 1);
        boolean down = checkIsland(grid, x, y - 1);

        return left && right && top && down;
    }
}