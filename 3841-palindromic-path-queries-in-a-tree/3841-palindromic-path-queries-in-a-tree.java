import java.util.*;

class Solution {
    int n, LOG = 17;
    int[] bit, tin, tout, depth;
    int[][] up;

    void add(int i, int d) {
        for (; i <= n; i += i & -i) bit[i] ^= d;
    }

    int query(int i) {
        int r = 0;
        for (; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    // xor delta on every node in subtree of u
    void subtreeXor(int u, int d) {
        if (d == 0) return;
        add(tin[u], d);
        add(tout[u] + 1, d);
    }

    int lca(int a, int b) {
        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
        int diff = depth[a] - depth[b];
        for (int k = 0; k < LOG; k++)
            if (((diff >> k) & 1) == 1) a = up[k][a];
        if (a == b) return a;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        bit = new int[n + 2];
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];

        // adjacency list using arrays
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[2 * (n - 1)];
        int[] to = new int[2 * (n - 1)];
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; nxt[cnt] = head[e[0]]; head[e[0]] = cnt++;
            to[cnt] = e[0]; nxt[cnt] = head[e[1]]; head[e[1]] = cnt++;
        }

        // iterative DFS from node 0
        int[] ptr = head.clone();
        int[] stack = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        up[0][0] = 0;
        tin[0] = ++timer;
        while (sp > 0) {
            int v = stack[sp - 1];
            if (ptr[v] != -1) {
                int e = ptr[v];
                ptr[v] = nxt[e];
                int w = to[e];
                if (w == up[0][v]) continue;   // skip parent
                up[0][w] = v;
                depth[w] = depth[v] + 1;
                tin[w] = ++timer;
                stack[sp++] = w;
            } else {
                tout[v] = timer;
                sp--;
            }
        }

        for (int k = 1; k < LOG; k++)
            for (int v = 0; v < n; v++)
                up[k][v] = up[k - 1][up[k - 1][v]];

        // current letters; build initial R[] inside the BIT
        char[] cur = s.toCharArray();
        for (int v = 0; v < n; v++) subtreeXor(v, 1 << (cur[v] - 'a'));

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);
                int delta = (1 << (cur[u] - 'a')) ^ (1 << (c - 'a'));
                subtreeXor(u, delta);
                cur[u] = c;
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);
                int x = query(tin[u]) ^ query(tin[v]) ^ (1 << (cur[l] - 'a'));
                ans.add((x & (x - 1)) == 0);
            }
        }
        return ans;
    }
}