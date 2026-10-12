class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] memo = new int[m][n][k];
        for (int[][] row2 : memo)
            for (int[] row1 : row2)
                Arrays.fill(row1, -1);

        return dfs(grid, k, 0, 0, 0, memo);
    }

    private int dfs(int[][] grid, int k, int x, int y, int remainder, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        if (x >= m || y >= n) return 0;

        remainder = (remainder + grid[x][y]) % k;

        if (x == m - 1 && y == n - 1) {
            return (remainder == 0) ? 1 : 0;
        }

        if (memo[x][y][remainder] != -1) {
            return memo[x][y][remainder];
        }

        int result = (dfs(grid, k, x + 1, y, remainder, memo)
                    + dfs(grid, k, x, y + 1, remainder, memo)) % MOD;

        return memo[x][y][remainder] = result;
    }
}