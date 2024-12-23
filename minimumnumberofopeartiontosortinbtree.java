import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        int swapCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            List<Integer> sortedValues = new ArrayList<>();

            // Collect all values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                sortedValues.add(node.val);  // Add to sortedValues to sort it later

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Sort the list of values at the current level
            Collections.sort(sortedValues);

            // We need to count the minimum number of swaps to sort the level
            Map<Integer, Integer> valueToSortedIndex = new HashMap<>();
            for (int i = 0; i < sortedValues.size(); i++) {
                valueToSortedIndex.put(sortedValues.get(i), i);
            }

            boolean[] visited = new boolean[levelValues.size()];

            for (int i = 0; i < levelValues.size(); i++) {
                if (visited[i] || levelValues.get(i) == sortedValues.get(i)) {
                    continue;  // Skip if already visited or already in correct position
                }

                // Find the cycle size
                int cycleSize = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = valueToSortedIndex.get(levelValues.get(j));
                    cycleSize++;
                }

                // If there's a cycle of size `cycleSize`, we need `cycleSize - 1` swaps
                if (cycleSize > 1) {
                    swapCount += (cycleSize - 1);
                }
            }
        }

        return swapCount;
    }
}

