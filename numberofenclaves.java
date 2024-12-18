class Solution {
    public int numEnclaves(int[][] grid) {
      // Your code here
         int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Mark all land cells connected to the boundary
        // Use a DFS to mark these cells as visited or processed
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0, n, m); // Left boundary
            if (grid[i][m - 1] == 1) dfs(grid, i, m - 1, n, m); // Right boundary
        }
        
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j, n, m); // Top boundary
            if (grid[n - 1][j] == 1) dfs(grid, n - 1, j, n, m); // Bottom boundary
        }
        
        // Step 2: Count land cells that cannot walk off the boundary
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // DFS to mark all land cells connected to the boundary
    private void dfs(int[][] grid, int x, int y, int n, int m) {
        // If the cell is out of bounds or is not land, return
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return;
        }

        // Mark the cell as visited (you can also mark it as 0 or any other value to indicate visited)
        grid[x][y] = 0;

        // Explore all four directions (up, down, left, right)
        dfs(grid, x + 1, y, n, m); // Down
        dfs(grid, x - 1, y, n, m); // Up
        dfs(grid, x, y + 1, n, m); // Right
        dfs(grid, x, y - 1, n, m); // Left
    }
}
