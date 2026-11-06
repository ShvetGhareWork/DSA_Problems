class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
    Arrays.sort(logs, (a, b) -> a[1] - b[1]);

    int[] answer = new int[queries.length];
    int[] count = new int[n + 1];
    int servers = 0;
    int i = 0;
    int j = 0;

    Integer[] order = new Integer[queries.length];
    for(int k = 0; k < queries.length; k++) order[k] = k;
    Arrays.sort(order, (a, b) -> queries[a] - queries[b]);

    for(int index : order){
        int q = queries[index];

            // Expand right: add logs with time <= q
            while (j < logs.length && logs[j][1] <= q) {
                count[logs[j][0]]++;
                if (count[logs[j][0]] == 1) servers++;
                j++;
            }

            // Shrink left: remove logs with time < q - x
            while (i < logs.length && logs[i][1] < q - x) {
                count[logs[i][0]]--;
                if (count[logs[i][0]] == 0) servers--;
                i++;
            }

            answer[index] = n - servers;
    }
    return answer;
    }
}