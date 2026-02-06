class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + nums[i];

        long totalSum = prefixSum[n - 1];
        
        int initialWays = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefixSum[i] * 2 == totalSum) initialWays++;
        }

        Map<Long, Integer> leftMap = new HashMap<>();
        Map<Long, Integer> rightMap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            rightMap.put(prefixSum[i], rightMap.getOrDefault(prefixSum[i], 0) + 1);
        }

        int maxWays = initialWays;

        for (int i = 0; i < n; i++) {
            long d = k - nums[i];
            
            int currentWays = 0;
            if ((totalSum + d) % 2 == 0) {
                currentWays += leftMap.getOrDefault((totalSum + d) / 2, 0);
            }
            if ((totalSum - d) % 2 == 0) {
                currentWays += rightMap.getOrDefault((totalSum - d) / 2, 0);
            }

            maxWays = Math.max(maxWays, currentWays);

            if (i < n - 1) {
                rightMap.put(prefixSum[i], rightMap.get(prefixSum[i]) - 1);
                leftMap.put(prefixSum[i], leftMap.getOrDefault(prefixSum[i], 0) + 1);
            }
        }

        return maxWays;
    }
}