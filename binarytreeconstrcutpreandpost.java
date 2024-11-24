class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
         // HashMap for quick access to postorder indices
        HashMap<Integer, Integer> postorderMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, postorderMap);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] postorder, int postStart, int postEnd,
                               HashMap<Integer, Integer> postorderMap) {
        // Base case: if there are no elements to process
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        // The root node is always the first node in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // If there's only one node, it's the leaf node
        if (preStart == preEnd) {
            return root;
        }
        
        // The second element in preorder is the left child of the root
        int leftChildValue = preorder[preStart + 1];
        
        // Find the left child's position in postorder
        int leftSubtreePostEnd = postorderMap.get(leftChildValue);
        
        // The left subtree size is determined by the position of the left child in postorder
        int leftSubtreeSize = leftSubtreePostEnd - postStart + 1;

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize,
                              postorder, postStart, leftSubtreePostEnd,
                              postorderMap);
        root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd,
                               postorder, leftSubtreePostEnd + 1, postEnd - 1,
                               postorderMap);
        
        return root;
    }
}
