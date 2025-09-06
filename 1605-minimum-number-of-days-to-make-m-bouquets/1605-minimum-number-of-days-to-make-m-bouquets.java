class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long)m * k;
        if (total > bloomDay.length) return -1;

        int low = 1, high = 0;
        for (int d : bloomDay) {
            high = Math.max(high, d);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int flowers = 0, bouquets = 0;
            for (int d : bloomDay) {
                if (d <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
