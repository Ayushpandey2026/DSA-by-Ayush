class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] result = new int[q];

        Arrays.sort(nums);

        int[][] sortedQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1]; 
            sortedQueries[i][2] = i;             
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();
        int numsIdx = 0;

        for (int i = 0; i < q; i++) {
            int xi = sortedQueries[i][0];
            int mi = sortedQueries[i][1];
            int originalIdx = sortedQueries[i][2];

            while (numsIdx < n && nums[numsIdx] <= mi) {
                trie.insert(nums[numsIdx]);
                numsIdx++;
            }

            if (numsIdx == 0) {
                result[originalIdx] = -1;
            } else {
                result[originalIdx] = trie.getMaxXor(xi);
            }
        }

        return result;
    }

    private static class Trie {
        private static class Node {
            Node[] children = new Node[2];
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int val) {
            Node curr = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new Node();
                }
                curr = curr.children[bit];
            }
        }

        public int getMaxXor(int val) {
            Node curr = root;
            int maxXor = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (val >> i) & 1;
                int desiredBit = 1 - bit;

                if (curr.children[desiredBit] != null) {
                    maxXor |= (1 << i);
                    curr = curr.children[desiredBit];
                } else {
                    curr = curr.children[bit];
                }
            }
            return maxXor;
        }
    }
}