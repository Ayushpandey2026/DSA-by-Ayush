class Solution {
    private int count = 0;

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int a : freq.keySet()) {
            adj.put(a, new ArrayList<>());
            for (int b : freq.keySet()) {
                if (isSquare(a + b)) {
                    adj.get(a).add(b);
                }
            }
        }

        for (int x : freq.keySet()) {
            freq.put(x, freq.get(x) - 1);
            backtrack(x, n - 1, freq, adj);
            freq.put(x, freq.get(x) + 1);
        }

        return count;
    }

    private void backtrack(int lastNum, int remaining, Map<Integer, Integer> freq, Map<Integer, List<Integer>> adj) {
        if (remaining == 0) {
            count++;
            return;
        }

        for (int nextNum : adj.get(lastNum)) {
            if (freq.get(nextNum) > 0) {
                freq.put(nextNum, freq.get(nextNum) - 1);
                backtrack(nextNum, remaining - 1, freq, adj);
                freq.put(nextNum, freq.get(nextNum) + 1); 
            }
        }
    }

    private boolean isSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }
}