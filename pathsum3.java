class Solution {
    public int pathSum(TreeNode root, int targetSum) {
          // Use a hashmap to store the cumulative sum frequencies
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Initialize with the base case
        return countPaths(root, 0, targetSum, prefixSumCount);
    }
     private int countPaths(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // Update the current sum
        currentSum += node.val;

        // Check how many times (currentSum - targetSum) has occurred
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum count with the current sum
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recur for the left and right children
        count += countPaths(node.left, currentSum, targetSum, prefixSumCount);
        count += countPaths(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack: remove the current sum from the map
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return count;
    }
}