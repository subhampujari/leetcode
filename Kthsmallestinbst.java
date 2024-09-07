class Solution {
    int idx = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        // int[] result = new int[2];
        inorderDFS(root, k);
        return result;
    }
    public void inorderDFS(TreeNode root, int k) {
        if ( root == null) return;

        inorderDFS(root.left, k);

        // idx += 1;
        if (++idx == k){
            result = root.val;
            return;
        }
        
        inorderDFS(root.right, k);
    }
    }
