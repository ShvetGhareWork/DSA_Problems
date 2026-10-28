class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];
        dp[0][0][grid[0][0]] = true;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0){
                    for(int x = 0; x < 1024; x++){
                        if(dp[i - 1][j][x]) dp[i][j][x ^ grid[i][j]] = true;
                    }
                }
                
                if(j > 0){
                    for(int y = 0; y < 1024; y++){
                        if(dp[i][j - 1][y]) dp[i][j][y ^ grid[i][j]] = true;
                    }
                }
            }
        }

        for(int r = 0; r < 1024; r++){
            if(dp[m - 1][n - 1][r]) return r;
        }

        return 0;
    }
}