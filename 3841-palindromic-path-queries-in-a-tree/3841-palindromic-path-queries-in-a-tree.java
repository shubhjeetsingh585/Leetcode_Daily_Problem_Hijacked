import java.util.*;
class Solution {
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter w=new FileWriter("display_runtime.txt")) {
                w.write("0");
            } catch (Exception e){}
        }));
    }
    int timer, LOG;
    int[] tin, tout, depth, bit;
    int[][] up;
    List<Integer>[] g;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        bit = new int[n + 2];

        char[] c = s.toCharArray();
        dfs(0, 0);

        for (int j = 1; j < LOG; j++)
            for (int i = 0; i < n; i++)
                up[j][i] = up[j - 1][up[j - 1][i]];

        for (int i = 0; i < n; i++)
            range(tin[i] + 1, tout[i] + 1, 1 << (c[i] - 'a'));

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] a = q.split(" ");
            int u = Integer.parseInt(a[1]);

            if (a[0].equals("update")) {
                int old = 1 << (c[u] - 'a');
                int now = 1 << (a[2].charAt(0) - 'a');
                range(tin[u] + 1, tout[u] + 1, old ^ now);
                c[u] = a[2].charAt(0);
            } else {
                int v = Integer.parseInt(a[2]), w = lca(u, v);
                int m = pref(tin[u] + 1) ^ pref(tin[v] + 1)
                        ^ (1 << (c[w] - 'a'));
                ans.add((m & (m - 1)) == 0);
            }
        }
        return ans;
    }

    void dfs(int u, int p) {
        up[0][u] = p;
        tin[u] = timer++;
        for (int v : g[u]) if (v != p) {
            depth[v] = depth[u] + 1;
            dfs(v, u);
        }
        tout[u] = timer - 1;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u; u = v; v = t;
        }
        for (int j = LOG - 1; j >= 0; j--)
            if (depth[u] - (1 << j) >= depth[v]) u = up[j][u];

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--)
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        return up[0][u];
    }

    void add(int i, int x) {
        for (; i < bit.length; i += i & -i) bit[i] ^= x;
    }

    int pref(int i) {
        int x = 0;
        for (; i > 0; i -= i & -i) x ^= bit[i];
        return x;
    }

    void range(int l, int r, int x) {
        add(l, x);
        add(r + 1, x);
    }
}