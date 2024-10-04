class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //base case 
        if(p==null && q==null)return true;
        if(p==null || q==null|| p.val!=q.val)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}