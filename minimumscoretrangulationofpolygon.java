class Solution {
    // variant of MATRIX CHAIN MULTIPLICATION
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return mcm(values, 0, n-1, dp);
    }
    public int mcm(int[] values, int i, int j, int[][] dp) {
        if (i >= j-1) return 0; // no triangle possible with 2 points
        if (dp[i][j] != -1) return dp[i][j];

        int minScore = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++) {
            int score = (values[i] * values[j] * values[k]) // current triangle score
             + mcm(values, i, k, dp)  // left partition score
             + mcm(values, k, j, dp); // right partition score
            
            minScore = Math.min(minScore, score);
        }
        return dp[i][j] = minScore;
    }
}
