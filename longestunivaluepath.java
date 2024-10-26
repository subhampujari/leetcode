class Solution {
    private int longestPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longestPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // Base case: return 0 for null nodes
        }
        
        // Recursively find the longest path in the left and right subtrees
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        
        int leftLength = 0;
        int rightLength = 0;

        // If the left child has the same value, extend the path
        if (node.left != null && node.left.val == node.val) {
            leftLength = leftPath + 1;
        }

        // If the right child has the same value, extend the path
        if (node.right != null && node.right.val == node.val) {
            rightLength = rightPath + 1;
        }

        // Update the longestPath with the maximum path through the current node
        longestPath = Math.max(longestPath, leftLength + rightLength);

        // Return the longest length of the univalue path through the current node
        return Math.max(leftLength, rightLength);
    }
}
