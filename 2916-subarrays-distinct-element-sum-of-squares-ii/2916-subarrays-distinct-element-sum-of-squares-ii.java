class Solution {
    static final int MOD = 1_000_000_007;
    long[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            update(1, 0, n - 1, last[nums[i]] + 1, i);
            last[nums[i]] = i;
            ans = (ans + sq[1]) % MOD;
        }
        return (int) ans;
    }

    void push(int p, int l, int r) {
        if (lazy[p] == 0) return;
        long v = lazy[p], len = r - l + 1;

        sq[p] = (sq[p] + 2 * v * sum[p] + v * v % MOD * len) % MOD;
        sum[p] = (sum[p] + v * len) % MOD;

        if (l != r) {
            lazy[p * 2] = (lazy[p * 2] + v) % MOD;
            lazy[p * 2 + 1] = (lazy[p * 2 + 1] + v) % MOD;
        }
        lazy[p] = 0;
    }

    void update(int p, int l, int r, int ql, int qr) {
        push(p, l, r);
        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            lazy[p] = 1;
            push(p, l, r);
            return;
        }

        int m = (l + r) / 2;
        update(p * 2, l, m, ql, qr);
        update(p * 2 + 1, m + 1, r, ql, qr);

        sum[p] = (sum[p * 2] + sum[p * 2 + 1]) % MOD;
        sq[p] = (sq[p * 2] + sq[p * 2 + 1]) % MOD;  
    }
}