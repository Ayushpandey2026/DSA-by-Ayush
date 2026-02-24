class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long totalCount = 0;
        Map<String, Integer> ratioMap = new HashMap<>();

       
        for (int r = 4; r < n - 2; r++) {
            int q = r - 2;
            for (int p = 0; p <= q - 2; p++) {
                int a = nums[p];
                int b = nums[q];
                int common = gcd(a, b);
                String ratio = (a / common) + "/" + (b / common);
                ratioMap.put(ratio, ratioMap.getOrDefault(ratio, 0) + 1);
            }

            for (int s = r + 2; s < n; s++) {
                int numS = nums[s];
                int numR = nums[r];
                int common = gcd(numS, numR);
                String targetRatio = (numS / common) + "/" + (numR / common);
                totalCount += ratioMap.getOrDefault(targetRatio, 0);
            }
        }

        return totalCount;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}