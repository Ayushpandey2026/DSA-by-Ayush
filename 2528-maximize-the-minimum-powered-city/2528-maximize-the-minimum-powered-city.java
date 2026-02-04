class Solution {

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }

        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);

            power[i] = prefix[right + 1] - prefix[left];
        }

        long low = 0, high = (long) 1e18;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (can(mid, power, n, r, k)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean can(long target, long[] power, int n, int r, int k) {

        long[] diff = new long[n + 1];
        long add = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {

            add += diff[i];
            long curr = power[i] + add;

            if (curr < target) {

                long need = target - curr;
                used += need;

                if (used > k) return false;

                add += need;

                int end = i + 2 * r + 1;
                if (end < n) diff[end] -= need;
            }
        }

        return true;
    }
}
