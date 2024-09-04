class Solution {
    public int numIslands(char[][] grid) {
       if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    public void dfs(char[][]grid,int i,int j){
      int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Check bounds and whether the cell is land
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] != '1') {
            return;
        }
        
        // Mark the cell as visited by setting it to '0'
        grid[i][j] = '0';
        
        // Visit all adjacent cells (up, down, left, right)
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // righ
    }
}
