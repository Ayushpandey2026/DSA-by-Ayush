class Fancy {
    private static final long MOD = 1_000_000_007;
    private List<Long> list;
    private long A = 1; 
    private long B = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
       
        long invA = power(A, MOD - 2);
        long stored = (((val - B + MOD) % MOD) * invA) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        B = (B + inc) % MOD;
    }

    public void multAll(int m) {
        A = (A * m) % MOD;
        B = (B * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        long res = (list.get(idx) * A % MOD + B) % MOD;
        return (int) res;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}