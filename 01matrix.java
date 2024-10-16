class Solution {
    public int[][] updateMatrix(int[][] mat) {
          int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all the 0s and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    distances[i][j] = Integer.MAX_VALUE; // Initialize distance for 1s to a large number
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            // Explore all four possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check boundaries and if the cell has not been visited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // Update the distance
                    distances[newX][newY] = distances[x][y] + 1;
                    // Mark as visited and add to the queue
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return distances;
    }
}