class Solution {
    private static final long MOD = 1000000007;

   public int numPermsDISequence(String s) {
       int n = s.length();
       s = "#" + s;  // Add a dummy character at the start for 1-based indexing
       long[][] dp = new long[n + 1][n + 1];  // Initialize DP table

       dp[0][0] = 1;  // Base case: 1 way to arrange an empty sequence

       for (int i = 1; i <= n; i++) {
           for (int j = 0; j <= i; j++) {
               if (s.charAt(i) == 'I') {  // 'I' means increasing
                   for (int k = 0; k < j; k++) {
                       dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                   }
               } else {  // 'D' means decreasing
                   for (int k = i - 1; k >= j; k--) {
                       dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                   }
               }
           }
       }

       long result = 0;
       for (int j = 0; j <= n; j++) {
           result = (result + dp[n][j]) % MOD;
       }

       return (int) result;  // Return the result as an integer
   }
}
