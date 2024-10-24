class Solution {
    public int strangePrinter(String s) {
        //we can solve it using the Dp and usnig the recursion 
       int n = s.length();
        // Create the DP table
        int[][] dp = new int[n][n];
        // Initialize the DP table with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, n - 1, dp, s);
    }
    // Method to count the number of minTurns required to print the string
    public int solve(int start, int end, int[][] dp, String s) {
        // Base case: If there's only one character
        if (start == end) return 1;

        // If already computed, return the cached result
        if (dp[start][end] != -1) return dp[start][end];

        int minTurns = Integer.MAX_VALUE;

        // Try all possible splits
        for (int k = start; k < end; k++) {
            // Calculate turns for the left and right segments
            minTurns = Math.min(minTurns, solve(start, k, dp, s) + solve(k + 1, end, dp, s));
        }

        // If the first and last characters are the same, we can reduce the turn count by 1
        if (s.charAt(start) == s.charAt(end)) {
            minTurns--; 
        }

        // Store the result in DP table
        dp[start][end] = minTurns;
        return minTurns;
    }
}