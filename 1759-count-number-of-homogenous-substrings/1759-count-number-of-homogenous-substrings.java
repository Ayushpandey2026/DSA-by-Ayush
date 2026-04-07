class Solution {
    public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        long totalCount = 0;
        int currentStreak = 0;
        char prevChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (currentChar == prevChar) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            
            totalCount = (totalCount + currentStreak) % MOD;
            prevChar = currentChar;
        }

        return (int) totalCount;
    }
}