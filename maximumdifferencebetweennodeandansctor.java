class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root,int maxValue,int minValue){
        if(root==null){
            return maxValue-minValue;
        }
        maxValue=Math.max(root.val,maxValue);
        minValue=Math.min(root.val,minValue);

        int left=dfs(root.left,maxValue,minValue);
        int right=dfs(root.right,maxValue,minValue);
        return Math.max(left,right);
    }
}
