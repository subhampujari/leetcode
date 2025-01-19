import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the min-heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int trappedWater = 0;
        int[] directions = {-1, 0, 1, 0, -1}; // Directions for up, right, down, left

        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();

            for (int d = 0; d < 4; d++) {
                int newRow = current.row + directions[d];
                int newCol = current.col + directions[d + 1];

                // Check if within bounds and not visited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    // Calculate the trapped water
                    trappedWater += Math.max(0, current.height - heightMap[newRow][newCol]);
                    // Update the height to the current height if it's lower
                    minHeap.offer(new Cell(newRow, newCol, Math.max(current.height, heightMap[newRow][newCol])));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return trappedWater;
    }

    // Helper class to store the cell's position and height
    static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    
}