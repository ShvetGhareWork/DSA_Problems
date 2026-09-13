class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(img1[i][j] == 1) list1.add(new int[]{i, j});
                if(img2[i][j] == 1) list2.add(new int[]{i, j});
            }
        }

        int[][] count = new int[2 * n][2 * n];
        int bestValue = 0;

        for(int[] num1 : list1){
            for(int[] num2 : list2){
                int dx = num2[0] - num1[0] + n;
                int dy = num2[1] - num1[1] + n;

                bestValue = Math.max(bestValue, ++count[dx][dy]);
            }
        }

        return bestValue;
    }
}