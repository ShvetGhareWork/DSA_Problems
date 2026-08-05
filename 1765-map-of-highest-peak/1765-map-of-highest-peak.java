class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] matrix = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] directions={ {0,1}, {0,-1}, {1,0}, {-1,0} };

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];

            for(int[] dir: directions){
                int dirRow = row + dir[0];
                int dirCol = col + dir[1];

                if(dirRow >= 0 && dirRow < m && dirCol >= 0 && dirCol < n && matrix[dirRow][dirCol] == -1) {
                    matrix[dirRow][dirCol] = matrix[row][col] + 1;

                    queue.add(new int[]{dirRow, dirCol});
                }
            }
        }

        return matrix;
    }
}