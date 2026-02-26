class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        if (threshold == 0) {
            List<Boolean> res = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) res.add(true);
            return res;
        }

       
        for (int z = threshold + 1; z <= n; z++) {
            for (int m = 2 * z; m <= n; m += z) {
                union(z, m, parent);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(find(query[0], parent) == find(query[1], parent));
        }

        return result;
    }

    private void union(int i, int j, int[] parent) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent); 
    }
}