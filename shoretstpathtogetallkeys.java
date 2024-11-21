class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startX = -1, startY = -1, totalKeys = 0;
        
        // Find the starting position '@' and count the total number of keys.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    startX = i;
                    startY = j;
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        // Directions for up, down, left, right movements
        int[] dirs = {-1, 0, 1, 0, -1, 0};
        
        // BFS queue: (x, y, collected keys, moves)
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int initialState = 0; // No keys collected initially
        queue.offer(new int[] {startX, startY, initialState, 0});
        visited.add(startX + "," + startY + "," + initialState);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], keys = curr[2], moves = curr[3];
            
            // If we have collected all keys, return the number of moves
            if (keys == (1 << totalKeys) - 1) {
                return moves;
            }
            
            // Explore four directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                
                // Skip out of bounds
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx].charAt(ny) == '#') {
                    continue;
                }
                
                // If it's a lock, check if we have the corresponding key
                char c = grid[nx].charAt(ny);
                if (c >= 'A' && c <= 'F') {
                    if ((keys & (1 << (c - 'A'))) == 0) {
                        continue; // Don't have the key for this lock
                    }
                }
                
                // If it's a key, update the keys bitmask
                int newKeys = keys;
                if (c >= 'a' && c <= 'f') {
                    newKeys |= (1 << (c - 'a')); // Collect the key
                }
                
                String state = nx + "," + ny + "," + newKeys;
                if (!visited.contains(state)) {
                    visited.add(state);
                    queue.offer(new int[] {nx, ny, newKeys, moves + 1});
                }
            }
        }
        
        // If we finish the BFS and haven't collected all keys, return -1
        return -1;
    }
}
