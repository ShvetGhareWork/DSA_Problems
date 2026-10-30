import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int m = edges.length;

        // adjacency list with arrays
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[m], to = new int[m], wt = new int[m];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            to[i] = edges[i][1];
            wt[i] = edges[i][2];
            nxt[i] = head[u];
            head[u] = i;
        }

        char[] c = labels.toCharArray();
        int W = k + 1;                       
        long total = (long) n * W;          
        long[] dist = new long[(int) total];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        dist[1] = 0;                        
        pq.add(1L);

        while (!pq.isEmpty()) {
            long cur = pq.poll();
            long d = cur / total;
            int s = (int) (cur % total);
            if (d > dist[s]) continue;       // stale entry

            int u = s / W, r = s % W;
            if (u == n - 1) return (int) d; 

            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                int nr = (c[u] == c[v]) ? r + 1 : 1;
                if (nr > k) continue;  
                int ns = v * W + nr;
                long nd = d + wt[e];
                if (nd < dist[ns]) {
                    dist[ns] = nd;
                    pq.add(nd * total + ns);
                }
            }
        }
        return -1;
    }
}