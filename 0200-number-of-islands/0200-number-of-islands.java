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

// class Solution {
//     public int numIslands(char[][] grid) {
//         Queue<int[]> queue = new LinkedList<>();
        
//         if(grid == null || grid.length == 0) return 0;
//         int isAnIsland = 0;

//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] directions = {
//             {1, 0}, // RIGHT
//             {-1, 0}, // LEFT
//             {0, 1}, // UP
//             {0, -1} // DOWN;
//         };

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == '1'){
//                     isAnIsland++;
//                     queue.offer(new int[]{i, j});
//                     while(!queue.isEmpty()){
//                         int[] curr = queue.poll();
//                         int x = curr[0];
//                         int y = curr[1];

//                         if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') continue;

//                         grid[x][y] = '0';

//                         for(int[] element : directions){
                            
//                             int newX = x + element[0];
//                             int newY = y + element[1];

//                             if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
//                                 queue.offer(new int[]{newX, newY});
//                             }
//                         }
//                     }
//                 }
//             }
//         }

//         return isAnIsland;
//     }
// }