class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Check boundaries and whether the cell is part of the island
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark the cell as visited
        visited[r][c] = true;

        // Count the area for this cell and explore neighbors
        int area = 1; // Current cell
        area += dfs(grid, r + 1, c); // Down
        area += dfs(grid, r - 1, c); // Up
        area += dfs(grid, r, c + 1); // Right
        area += dfs(grid, r, c - 1); // Left

        return area;
    }
}
