import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        Map<Integer, List<Integer>> leftSums = new HashMap<>();
        Map<Integer, List<Integer>> rightSums = new HashMap<>();

        generateSums(nums, 0, n, leftSums);
        generateSums(nums, n, 2 * n, rightSums);

        int minDiff = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> left = leftSums.get(k);
            List<Integer> right = rightSums.get(n - k);
            Collections.sort(right);

            for (int s1 : left) {
               
                int target = (totalSum / 2) - s1;
                
                int idx = Collections.binarySearch(right, target);
                if (idx < 0) idx = -(idx + 1);

                if (idx < right.size()) {
                    int s2 = right.get(idx);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (s1 + s2)));
                }
                if (idx > 0) {
                    int s2 = right.get(idx - 1);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (s1 + s2)));
                }
            }
        }

        return minDiff;
    }

    private void generateSums(int[] nums, int start, int end, Map<Integer, List<Integer>> map) {
        int count = end - start;
        for (int i = 0; i < (1 << count); i++) {
            int sum = 0;
            int numElements = 0;
            for (int j = 0; j < count; j++) {
                if (((i >> j) & 1) == 1) {
                    sum += nums[start + j];
                    numElements++;
                }
            }
            map.computeIfAbsent(numElements, k -> new ArrayList<>()).add(sum);
        }
    }
}