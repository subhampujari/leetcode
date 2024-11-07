class Solution {
    private int min=Integer.MAX_VALUE;
    private Integer prev=null;
   public int minDiffInBST(TreeNode root) {
       inorderTaversal(root);
       return min;
   }
   public void inorderTaversal(TreeNode root){
       if(root==null){
           return;
       }

       inorderTaversal(root.left);
       if(prev!=null){
           int diff=root.val-prev;
           min=Math.min(min,diff);
       }
       prev=root.val;
       inorderTaversal(root.right);
   }
}