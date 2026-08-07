class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Queue to store coordinates as int arrays {row, col}
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        
        // Start from (0, 0)
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        
        // Direction arrays for up, left, down, right
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        int[] ans = new int[2];
        
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0];
            int y = front[1];
            
            int maxi = mat[x][y];
            int maxRow = x;
            int maxCol = y;
            
            // Check all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Validate bounds, check if neighbor is greater, and not visited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n 
                    && mat[newX][newY] > maxi && !vis[newX][newY]) {
                    
                    maxi = mat[newX][newY];
                    maxRow = newX;
                    maxCol = newY;
                }
            }
            
            // If current element is the maximum among neighbors (peak found)
            if (maxi == mat[x][y]) {
                ans[0] = x;
                ans[1] = y;
                // Note: In the original C++ code, the loop continues until the queue is empty.
                // We break here if we want to return immediately upon finding the first peak.
                // However, to strictly match the C++ logic which might process other paths,
                // we could remove 'break'. But logically, once a peak is found, we are done.
                break; 
            } else {
                // Move to the greater neighbor
                q.offer(new int[]{maxRow, maxCol});
                vis[maxRow][maxCol] = true;
            }
        }
        
        return ans;
    }
}