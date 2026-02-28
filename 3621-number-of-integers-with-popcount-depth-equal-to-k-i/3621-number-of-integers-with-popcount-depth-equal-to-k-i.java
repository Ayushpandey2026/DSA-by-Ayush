class Solution {
    public long popcountDepth(long n, int k) {
        if (k == 0) return 1; 
        
        int[] depth = new int[65];
        depth[1] = 0;
        for (int i = 2; i <= 64; i++) {
            depth[i] = 1 + depth[Integer.bitCount(i)];
        }
        
        List<Integer> targets = new ArrayList<>();
        for (int i = 1; i <= 64; i++) {
            if (depth[i] == k - 1) {
                targets.add(i);
            }
        }
        
        long totalCount = 0;
        for (int target : targets) {
            totalCount += countWithSetBits(n, target);
        }
     
        if (k == 1) totalCount--;
        
        return totalCount;
    }

    private long countWithSetBits(long n, int target) {
        String binary = Long.toBinaryString(n);
        int len = binary.length();
        long count = 0;
        int used = 0;
        
        for (int i = 0; i < len; i++) {
            if (binary.charAt(i) == '1') {
                count += nCr(len - 1 - i, target - used);
                used++;
            }
            if (used > target) break;
        }
        
        if (used == target) count++;
        
        return count;
    }

    private long[][] memo = new long[65][65];
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (memo[n][r] != 0) return memo[n][r];
        return memo[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}