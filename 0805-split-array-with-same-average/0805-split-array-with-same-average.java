import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        
        int totalSum = 0;
        for (int x : nums) totalSum += x;
        
        int m = n / 2;
        Set<Integer>[] leftSums = new HashSet[m + 1];
        for (int i = 0; i <= m; i++) leftSums[i] = new HashSet<>();
        leftSums[0].add(0);
        
        for (int x : nums) {
            if (m-- <= 0) break; 
            for (int i = leftSums.length - 1; i >= 1; i--) {
                for (int s : leftSums[i - 1]) {
                    leftSums[i].add(s + x);
                }
            }
        }
        
        m = n / 2;
        int rSize = n - m;
        Set<Integer>[] rightSums = new HashSet[rSize + 1];
        for (int i = 0; i <= rSize; i++) rightSums[i] = new HashSet<>();
        rightSums[0].add(0);
        
        for (int i = m; i < n; i++) {
            int x = nums[i];
            for (int j = rSize; j >= 1; j--) {
                for (int s : rightSums[j - 1]) {
                    rightSums[j].add(s + x);
                }
            }
        }

        for (int k = 1; k <= n / 2; k++) {
            if ((totalSum * k) % n == 0) {
                int targetSum = (totalSum * k) / n;
                for (int i = 0; i <= Math.min(k, m); i++) {
                    int j = k - i;
                    if (j > rSize) continue;
                    
                    for (int sLeft : leftSums[i]) {
                        if (rightSums[j].contains(targetSum - sLeft)) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}