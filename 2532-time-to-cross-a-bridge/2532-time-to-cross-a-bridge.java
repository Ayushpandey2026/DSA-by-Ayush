class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        // Efficiency comparator: More time = less efficient = higher priority
        // If times are equal, higher index = less efficient = higher priority
        Comparator<Integer> efficiencyComparator = (a, b) -> {
            int timeA = time[a][0] + time[a][2];
            int timeB = time[b][0] + time[b][2];
            if (timeA != timeB) return timeB - timeA;
            return b - a;
        };

        PriorityQueue<Integer> leftWaiting = new PriorityQueue<>(efficiencyComparator);
        PriorityQueue<Integer> rightWaiting = new PriorityQueue<>(efficiencyComparator);
        
        // Working queues: [finishTime, workerIndex]
        PriorityQueue<int[]> leftWorking = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> rightWorking = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < k; i++) leftWaiting.add(i);

        int curTime = 0;
        int boxesToPick = n;
        int boxesPutDown = 0;

        while (boxesPutDown < n) {
            // 1. Move workers who finished working to the waiting queues
            while (!leftWorking.isEmpty() && leftWorking.peek()[0] <= curTime) {
                leftWaiting.add(leftWorking.poll()[1]);
            }
            while (!rightWorking.isEmpty() && rightWorking.peek()[0] <= curTime) {
                rightWaiting.add(rightWorking.poll()[1]);
            }

            // 2. Decide who uses the bridge
            if (!rightWaiting.isEmpty()) {
                int i = rightWaiting.poll();
                curTime += time[i][2]; // rightToLeft
                leftWorking.add(new int[]{curTime + time[i][3], i}); // starts putNew
                boxesPutDown++;
            } else if (boxesToPick > 0 && !leftWaiting.isEmpty()) {
                int i = leftWaiting.poll();
                curTime += time[i][0]; // leftToRight
                rightWorking.add(new int[]{curTime + time[i][1], i}); // starts pickOld
                boxesToPick--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (boxesToPick > 0 && !leftWorking.isEmpty()) nextTime = Math.min(nextTime, leftWorking.peek()[0]);
                if (!rightWorking.isEmpty()) nextTime = Math.min(nextTime, rightWorking.peek()[0]);
                
                if (nextTime != Integer.MAX_VALUE) curTime = nextTime;
            }
        }

        return curTime;
    }
}