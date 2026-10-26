class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long s = checkIsland(grid, i, j);
                    if(s % k == 0) count++;
                }
            }
        }

        return count;
    }

    private long checkIsland(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
            return 0;

        long sum = grid[x][y];
        grid[x][y] = 0;

        sum += checkIsland(grid, x - 1, y);
        sum += checkIsland(grid, x + 1, y);
        sum += checkIsland(grid, x, y + 1);
        sum += checkIsland(grid, x, y - 1);

        return sum;
    }
}