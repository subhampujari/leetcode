class Solution {
    public static final int MOD = 1000000007;
   public int countPathsWithXorValue(int[][] grid, int k) {
      /* int m = grid.length;
       int n = grid[0].length;

       // DP table, where each entry at dp[i][j] is a map storing the count of XOR values at that cell
       Map<Integer, Integer>[][] dp = new HashMap[m][n];

       // Initialize the DP table
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               dp[i][j] = new HashMap<>();
           }
       }

       // Initialize the starting point (0, 0) with its XOR value
       dp[0][0].put(grid[0][0], 1);

       // Iterate over the grid
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               // Iterate over all the XOR values at dp[i][j]
               for (Map.Entry<Integer, Integer> entry : dp[i][j].entrySet()) {
                   int xor_val = entry.getKey();
                   int count = entry.getValue();

                   // If we can move right (i, j + 1)
                   if (j + 1 < n) {
                       int newXor = xor_val ^ grid[i][j + 1];
                       dp[i][j + 1].put(newXor, (dp[i][j + 1].getOrDefault(newXor, 0) + count) % MOD);
                   }

                   // If we can move down (i + 1, j)
                   if (i + 1 < m) {
                       int newXor = xor_val ^ grid[i + 1][j];
                       dp[i + 1][j].put(newXor, (dp[i + 1][j].getOrDefault(newXor, 0) + count) % MOD);
                   }
               }
           }
       }

       // The answer will be stored in dp[m-1][n-1][k]
       return dp[m - 1][n - 1].getOrDefault(k, 0);*/
       int mod = 1_000_000_007;
       int m = grid.length;
       int n = grid[0].length;
       int dp[][][] = new int[m][n][16];
       dp[0][0][grid[0][0]] = 1;
       int last = grid[0][0];
       for (int i = 1; i < m; i++) {
           last ^= grid[i][0];
           dp[i][0][last] = 1;
       }
       last = grid[0][0];
       for (int i = 1; i < n; i++) {
           last ^= grid[0][i];
           dp[0][i][last] = 1;
       }
       for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
               for (int l = 0; l < 16; l++) {
                   dp[i][j][l ^ grid[i][j]] = (dp[i-1][j][l] + dp[i][j-1][l])%mod;
               }
           }
       }
       return dp[m-1][n-1][k];
   }
}
