class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(i, j, m, n, grid));
                }
            }
        }
        return maxFish;
    }

    public int dfs(int row, int col, int m, int n, int[][] grid) {
        // Base case: out of bounds or no fish in the current cell
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }

        // Save the number of fish in the current cell
        int fish = grid[row][col];

        // Mark this cell as visited by setting its value to 0
        grid[row][col] = 0;

        // Explore all 4 directions and accumulate the number of fish
        int sum = fish + dfs(row + 1, col, m, n, grid) 
                + dfs(row - 1, col, m, n, grid) 
                + dfs(row, col + 1, m, n, grid) 
                + dfs(row, col - 1, m, n, grid);

        // Return the total fish found from this cell
        return sum;
    }
}

