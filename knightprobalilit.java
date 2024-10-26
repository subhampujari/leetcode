class Solution {
    private static final int[][] DIRECTIONS = {
    {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
};

public double knightProbability(int n, int k, int row, int column) {
    // Create a 2D DP array for the current and previous moves
    double[][] dp = new double[n][n];
    dp[row][column] = 1.0; // Starting position
    
    // Iterate through the number of moves
    for (int moves = 0; moves < k; moves++) {
        double[][] nextDp = new double[n][n]; // Temporary array for the next move
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] > 0) {
                    // Try all 8 possible knight moves
                    for (int[] direction : DIRECTIONS) {
                        int newRow = r + direction[0];
                        int newCol = c + direction[1];
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                            // Valid move
                            nextDp[newRow][newCol] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
        }
        dp = nextDp; // Move to the next state
    }
    
    // Calculate the probability of being on the board after k moves
    double probability = 0.0;
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            probability += dp[r][c];
        }
    }
    
    return probability;
}
}
