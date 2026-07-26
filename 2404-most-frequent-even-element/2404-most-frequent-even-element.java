class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int ans = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                int count = freqMap.getOrDefault(num, 0) + 1;
                freqMap.put(num, count);

                if (count > maxFreq || (count == maxFreq && (ans == -1 || num < ans))) {
                    maxFreq = count;
                    ans = num;
                }
            }
        }
        return ans;
    }
}