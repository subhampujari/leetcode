class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // Step 1: Build a new tree from the array `a + [val]` by inserting `val`.
        List<Integer> list = inorderTraversal(root); // Get the inorder traversal of the existing tree
        list.add(val); // Add the new value to the list
        return constructTree(list);
    }

    private List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node != null) {
            inorderTraversalHelper(node, list);
        }
        return list;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversalHelper(node.left, list);
        list.add(node.val);
        inorderTraversalHelper(node.right, list);
    }

    private TreeNode constructTree(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        // Find the maximum element and its index
        int maxIdx = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
                maxIdx = i;
            }
        }
        
        // Create the root with the maximum value
        TreeNode root = new TreeNode(maxValue);
        
        // Recursively construct the left and right subtrees
        root.left = constructTree(list.subList(0, maxIdx));
        root.right = constructTree(list.subList(maxIdx + 1, list.size()));
        
        return root;
    }
}
