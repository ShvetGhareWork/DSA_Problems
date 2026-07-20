class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k %= total;

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(j);
            }
            answer.add(row);
        }
            
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int oldIndex = n * i + j;
                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                answer.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return answer;
    }

    
}