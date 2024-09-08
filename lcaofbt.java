class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case if the any one of the node is null return root
        if(root ==null||root==p||root==q){
            return root;
        }
        //recrsive call for the left subtree
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        //Recsurive call for the right SubTree
         TreeNode right=lowestCommonAncestor(root.right,p,q);
         //cheking if both of the left and right are null then we return the root
         if(left==null){
            return right;
         }else if(right==null){
            return left;
         }else{
            return root;
         }
    }
}
