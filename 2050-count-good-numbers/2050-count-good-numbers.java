class Solution {
    private static final int MOD = 1000000007;
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2; 
        long oddCount = n / 2;         

        long evenPart = modPow(5, evenCount, MOD);
        long oddPart = modPow(4, oddCount, MOD);

        return (int)((evenPart * oddPart) % MOD);
    }
}
