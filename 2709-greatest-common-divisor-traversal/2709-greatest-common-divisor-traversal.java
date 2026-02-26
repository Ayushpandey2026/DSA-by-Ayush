class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        
        for (int x : nums) if (x == 1) return false;

        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<Integer, Integer> primeToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            for (int d = 2; d * d <= temp; d++) {
                if (temp % d == 0) {
                    union(i, d, primeToIndex, parent, size);
                    while (temp % d == 0) temp /= d;
                }
            }
            if (temp > 1) {
                union(i, temp, primeToIndex, parent, size);
            }
        }

        int root = find(0, parent);
        return size[root] == n;
    }

    private void union(int index, int prime, Map<Integer, Integer> map, int[] parent, int[] size) {
        if (map.containsKey(prime)) {
           
            int root1 = find(index, parent);
            int root2 = find(map.get(prime), parent);
            if (root1 != root2) {
                if (size[root1] < size[root2]) {
                    parent[root1] = root2;
                    size[root2] += size[root1];
                } else {
                    parent[root2] = root1;
                    size[root1] += size[root2];
                }
            }
        } else {
            map.put(prime, index);
        }
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent); 
    }
}