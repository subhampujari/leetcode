import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public int largestIsland(int[][] grid) {
        // A map to store the size of each island with its unique ID
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2; // Start island IDs from 2 to distinguish from original land (1)

        // Step 1: Mark all islands and calculate their sizes
        for (int currentRow = 0; currentRow < grid.length; ++currentRow) {
            for (int currentColumn = 0; currentColumn < grid[0].length; ++currentColumn) {
                // If it's a land cell (1), start exploring this island
                if (grid[currentRow][currentColumn] == 1) {
                    // Mark the island with a unique ID and calculate its size
                    islandSizes.put(islandId, exploreIsland(grid, islandId, currentRow, currentColumn));
                    ++islandId; // Increment the island ID for the next island
                }
            }
        }

        // If there are no islands (no 1s), return 1 because we can turn a 0 into a 1
        if (islandSizes.isEmpty()) {
            return 1;
        }

        // If the entire grid is a single island, return its size or its size + 1
        if (islandSizes.size() == 1) {
            --islandId; // Adjust the islandId back to the only island
            return (islandSizes.get(islandId) == grid.length * grid[0].length)
                ? islandSizes.get(islandId) // If the entire grid is an island, return its size
                : islandSizes.get(islandId) + 1; // Otherwise, we can expand the island by converting one water cell
        }

        // Step 2: Try converting each 0 (water cell) to 1 and calculate the potential largest island size
        int maxIslandSize = 1; // The smallest possible island is 1 (if a 0 is converted to a 1)

        for (int currentRow = 0; currentRow < grid.length; ++currentRow) {
            for (int currentColumn = 0; currentColumn < grid[0].length; ++currentColumn) {
                // Only consider water cells (0)
                if (grid[currentRow][currentColumn] == 0) {
                    int currentIslandSize = 1; // Start with the current cell becoming land (size = 1)
                    Set<Integer> neighboringIslands = new HashSet<>(); // Set to keep track of unique neighboring islands

                    // Check down (currentRow + 1)
                    if (currentRow + 1 < grid.length && grid[currentRow + 1][currentColumn] > 1) {
                        neighboringIslands.add(grid[currentRow + 1][currentColumn]);
                    }

                    // Check up (currentRow - 1)
                    if (currentRow - 1 >= 0 && grid[currentRow - 1][currentColumn] > 1) {
                        neighboringIslands.add(grid[currentRow - 1][currentColumn]);
                    }

                    // Check right (currentColumn + 1)
                    if (currentColumn + 1 < grid[0].length && grid[currentRow][currentColumn + 1] > 1) {
                        neighboringIslands.add(grid[currentRow][currentColumn + 1]);
                    }

                    // Check left (currentColumn - 1)
                    if (currentColumn - 1 >= 0 && grid[currentRow][currentColumn - 1] > 1) {
                        neighboringIslands.add(grid[currentRow][currentColumn - 1]);
                    }

                    // Add the sizes of all unique neighboring islands to the current island size
                    for (int id : neighboringIslands) {
                        currentIslandSize += islandSizes.get(id);
                    }

                    // Update the maximum island size found
                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        // Return the maximum island size possible
        return maxIslandSize;
    }

    // Helper function to explore an island and calculate its size
    private int exploreIsland(
        int[][] grid,
        int islandId,
        int currentRow,
        int currentColumn
    ) {
        // If out of bounds or current cell is not land (1), return 0 (base case)
        if (
            currentRow < 0 || currentRow >= grid.length ||
            currentColumn < 0 || currentColumn >= grid[0].length ||
            grid[currentRow][currentColumn] != 1
        ) return 0;

        // Mark the current cell as part of the island with the given islandId
        grid[currentRow][currentColumn] = islandId;

        // Recursively explore all four neighboring cells (down, up, right, left)
        return (
            1 + // Count the current cell
            exploreIsland(grid, islandId, currentRow + 1, currentColumn) + // Down
            exploreIsland(grid, islandId, currentRow - 1, currentColumn) + // Up
            exploreIsland(grid, islandId, currentRow, currentColumn + 1) + // Right
            exploreIsland(grid, islandId, currentRow, currentColumn - 1)   // Left
        );
    }
}

