class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long high = 1_000_000_000_000_000_000L; 
        
        int minWorkerTime = workerTimes[0];
        for (int w : workerTimes) minWorkerTime = Math.min(minWorkerTime, w);
        high = (long) minWorkerTime * mountainHeight * (mountainHeight + 1) / 2;

        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(long maxTime, int targetHeight, int[] workerTimes) {
        long totalHeightReduced = 0;
        for (int w : workerTimes) {
            long val = (2 * maxTime) / w;
            long x = (long) ((-1 + Math.sqrt(1 + 4 * val)) / 2);
            totalHeightReduced += x;
            
            if (totalHeightReduced >= targetHeight) return true;
        }
        return totalHeightReduced >= targetHeight;
    }
}