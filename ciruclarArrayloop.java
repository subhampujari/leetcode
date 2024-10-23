class Solution {
    public boolean circularArrayLoop(int[] nums) {
         int n = nums.length;
        Set<Integer> visitedIndices = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (visitedIndices.contains(i)) {
                continue; // Skip already visited indices
            }

            int slow = i, fast = i;
            int currentDirection = nums[i] > 0 ? 1 : -1;

            while (true) {
                // Add the current indices to the visited set
                visitedIndices.add(slow);
                visitedIndices.add(fast);

                slow = getNextIndex(nums, slow, currentDirection);
                fast = getNextIndex(nums, fast, currentDirection);

                if (slow == -1 || fast == -1) {
                    break; // Out of bounds or direction mismatch
                }

                fast = getNextIndex(nums, fast, currentDirection); // Move fast again

                if (fast == -1) {
                    break; // Out of bounds or direction mismatch
                }

                if (slow == fast) {
                    return true; // Cycle found
                }
            }
        }
        
        return false; // No cycle found
    }

    private int getNextIndex(int[] nums, int index, int currDir) {
        int n = nums.length;
        int nextIndex = (index + nums[index]) % n;

        // Handle negative index wrapping
        if (nextIndex < 0) {
            nextIndex += n;
        }

        int nextDir = nums[nextIndex] > 0 ? 1 : -1;

        // Check for direction mismatch or single element loop
        if (currDir != nextDir || index == nextIndex) {
            return -1;
        }

        return nextIndex;
    }
}