class Solution {
    public boolean canCross(int[] stones) {
         // Create a map to store the positions of the stones with their possible jumps
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        // Add stones to the map
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Initial jump: the frog can jump 1 unit from the first stone
        map.get(0).add(1);

        // Exploring each stone
        for (int stone : stones) {
            HashSet<Integer> jumps = map.get(stone); // Get the possible jumps for the current stone
            
            for (int jump : jumps) {
                int nextStone = stone + jump; // Calculate the next stone position
                
                // Check if the next stone is the last stone
                if (nextStone == stones[stones.length - 1]) {
                    return true;
                }
                
                // If the next stone exists, add possible jumps to that stone
                if (map.containsKey(nextStone)) {
                    if (jump - 1 > 0) {
                        map.get(nextStone).add(jump - 1); // Add jump - 1
                    }
                    map.get(nextStone).add(jump); // Add jump
                    map.get(nextStone).add(jump + 1); // Add jump + 1
                }
            }
        }
        
        return false; // If we finish and haven't returned true, the frog can't cross
    }
}
