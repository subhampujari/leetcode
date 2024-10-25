class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        //wecan solve this question using the Heap and also BFS or with dfs ..
      int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Step 1: Collect the trees' positions and heights
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        // Step 2: Sort the trees based on height
        trees.sort(Comparator.comparingInt(a -> a[2]));

        // Step 3: Initialize starting position
        int totalSteps = 0;
        int startX = 0, startY = 0;

        for (int[] tree : trees) {
            int steps = dijkstra(forest, startX, startY, tree[0], tree[1], directions);
            if (steps == -1) {
                return -1; // Tree is unreachable
            }
            totalSteps += steps;
            // Update position and cut the tree
            startX = tree[0];
            startY = tree[1];
            forest.get(startX).set(startY, 1); // Mark as empty
        }

        return totalSteps;
    }
   private int dijkstra(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY, int[][] directions) {
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{startX, startY, 0}); // {x, y, steps}
        
        boolean[][] visited = new boolean[m][n];
        visited[startX][startY] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], steps = current[2];

            if (x == targetX && y == targetY) {
                return steps; // Found the target tree
            }

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                // Check bounds and if the cell can be walked through
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && forest.get(newX).get(newY) != 0) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{newX, newY, steps + 1});
                }
            }
        }
        
        return -1; // If the target tree is unreachable
    }
}


