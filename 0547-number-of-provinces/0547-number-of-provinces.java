class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visitedArray = new boolean[isConnected.length];
        int provinces = 0;

        for(int i = 0; i < isConnected.length; i++){
            if(!visitedArray[i]){
                dfs(i, isConnected, visitedArray);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visitedArray){
        visitedArray[node] = true;

        for(int i = 0; i < isConnected.length; i++){
            if (isConnected[node][i] == 1 && !visitedArray[i]){
                dfs(i, isConnected, visitedArray);
            }
        }
    }
}