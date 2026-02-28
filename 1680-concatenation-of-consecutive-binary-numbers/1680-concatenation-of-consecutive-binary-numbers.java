class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1_000_000_007;
        long result = 0;
        int currentBitLength = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                currentBitLength++;
            }
            result = ((result << currentBitLength) | i) % MOD;
        }
        return (int) result;
    }
}