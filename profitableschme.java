class Solution {
    public int dp[][][];  // 3D DP array to store subproblem solutions
   public int mod = 1000000007;  // Modulo value for the result
   
   public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
       dp = new int[group.length + 1][n + 1][minProfit + 1];  // Initialize DP array
       
       // Initialize the DP array with -1 for all values (indicating uncomputed states)
       for (int i = 0; i <= group.length; i++) {
           for (int j = 0; j <= n; j++) {
               for (int k = 0; k <= minProfit; k++) {
                   dp[i][j][k] = -1;
               }
           }
       }
       
       return solve(0, 0, 0, n, minProfit, group, profit);  // Start the recursive solution
   }

   // Recursive function to compute the number of profitable schemes
   public int solve(int k, int i, int j, int n, int minProfit, int[] group, int[] profit) {
       if (k == group.length) {
           // If we've processed all crimes, check if the current state is valid
           if (j >= minProfit && i <= n) return 1;
           return 0;
       }
       
       if (i > n) return 0;  // If we've used more than n members, return 0
       
       if (dp[k][i][j] != -1) return dp[k][i][j];  // Return precomputed result if available
       
       // Option 1: Don't include the current crime
       int notInclude = solve(k + 1, i, j, n, minProfit, group, profit);
       
       // Option 2: Include the current crime (if enough members are available)
       int include = 0;
       if (i + group[k] <= n) {
           include = solve(k + 1, i + group[k], Math.min(j + profit[k], minProfit), n, minProfit, group, profit);
       }
       
       // Store the result in the DP table and return it
       dp[k][i][j] = (include % mod + notInclude % mod) % mod;
       return dp[k][i][j];
   }
}
