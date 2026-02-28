class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int maxVariance = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[i] == 0 || freq[j] == 0) continue;

                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);

                int majorCount = 0;
                int minorCount = 0;
                boolean hasRestOfMinor = freq[j] > 0;

                for (char c : s.toCharArray()) {
                    if (c == major) {
                        majorCount++;
                    } else if (c == minor) {
                        minorCount++;
                    }

                    if (minorCount > 0) {
                        maxVariance = Math.max(maxVariance, majorCount - minorCount);
                    } else if (hasRestOfMinor) {
                        maxVariance = Math.max(maxVariance, majorCount - 1);
                    }
                    if (majorCount < minorCount) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}