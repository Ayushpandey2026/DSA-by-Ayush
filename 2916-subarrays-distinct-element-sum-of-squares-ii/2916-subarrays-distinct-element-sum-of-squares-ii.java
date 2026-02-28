class Solution {
    private static final int MOD = 1_000_000_007;
    class Node {
        long sum1; 
        long sum2; 
        long lazy;
    }

    private Node[] tree;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) tree[i] = new Node();

        Map<Integer, Integer> lastPos = new HashMap<>();
        long totalAns = 0;

        for (int j = 0; j < n; j++) {
            int prev = lastPos.getOrDefault(nums[j], -1);
            
            update(1, 0, n - 1, prev + 1, j, 1);
            totalAns = (totalAns + tree[1].sum2) % MOD;
            
            lastPos.put(nums[j], j);
        }

        return (int) totalAns;
    }

    private void pushUp(int rt) {
        tree[rt].sum1 = (tree[rt << 1].sum1 + tree[rt << 1 | 1].sum1) % MOD;
        tree[rt].sum2 = (tree[rt << 1].sum2 + tree[rt << 1 | 1].sum2) % MOD;
    }

    private void apply(int rt, int l, int r, long val) {
        long len = r - l + 1;
        tree[rt].sum2 = (tree[rt].sum2 + (2 * val * tree[rt].sum1) % MOD + (len * val % MOD * val % MOD)) % MOD;
        tree[rt].sum1 = (tree[rt].sum1 + len * val) % MOD;
        tree[rt].lazy = (tree[rt].lazy + val) % MOD;
    }

    private void pushDown(int rt, int l, int r) {
        if (tree[rt].lazy != 0) {
            int mid = (l + r) >> 1;
            apply(rt << 1, l, mid, tree[rt].lazy);
            apply(rt << 1 | 1, mid + 1, r, tree[rt].lazy);
            tree[rt].lazy = 0;
        }
    }

    private void update(int rt, int l, int r, int qL, int qR, int val) {
        if (qL <= l && r <= qR) {
            apply(rt, l, r, val);
            return;
        }
        pushDown(rt, l, r);
        int mid = (l + r) >> 1;
        if (qL <= mid) update(rt << 1, l, mid, qL, qR, val);
        if (qR > mid) update(rt << 1 | 1, mid + 1, r, qL, qR, val);
        pushUp(rt);
    }
}