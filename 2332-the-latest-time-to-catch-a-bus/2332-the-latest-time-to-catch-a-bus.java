import java.util.*;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int n = buses.length;
        int m = passengers.length;
        int pIdx = 0;
        int passengersOnLastBus = 0;
        for (int i = 0; i < n; i++) {
            passengersOnLastBus = 0;
            while (passengersOnLastBus < capacity && pIdx < m && passengers[pIdx] <= buses[i]) {
                pIdx++;
                passengersOnLastBus++;
            }
        }

        int bestTime;
        if (passengersOnLastBus < capacity) {
            bestTime = buses[n - 1];
        } else {
            bestTime = passengers[pIdx - 1];
        }

        Set<Integer> passengerSet = new HashSet<>();
        for (int p : passengers) passengerSet.add(p);
        
        while (passengerSet.contains(bestTime)) {
            bestTime--;
        }
        return bestTime;
    }
}