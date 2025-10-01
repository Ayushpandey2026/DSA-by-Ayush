class Solution {
      static final long MOD = 1000000007;
   long power(long base, long exp) {
        if (exp == 0) return 1;   

        long half = power(base, exp / 2);
        half = (half * half) % MOD;

        if (exp % 2 == 0) {
            return half;
        } else {
            return (half * base) % MOD;
        }
    }
    public int countGoodNumbers(long n) {
          long evencnt = (n+1)/2;
          long oddcnt = n/2;

          long ans1 = power(5,evencnt);
          long ans2 = power(4, oddcnt);
            
           return (int)((ans1*ans2)%MOD);
    }
}