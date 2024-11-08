class Solution {
    public int numTilings(int n) {
         // Define the modulo constant
        final int MOD = 1000000007;
        
        // Array to store the number of ways to tile a 2 x n board
        long[] v = new long[1001];
        
        // Base cases
        v[1] = 1;
        v[2] = 2;
        v[3] = 5;
        
        // If N is less than or equal to 3, return the precomputed value
        if (n <= 3) {
            return (int) v[n];
        }
        
        // Fill the dp array for all n >= 4
        for (int i = 4; i <= n; ++i) {
            v[i] = (2 * v[i - 1] + v[i - 3]) % MOD;
        }
        
        // Return the result for the given N
        return (int) v[n];
    }
}
