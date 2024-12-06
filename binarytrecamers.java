class Solution {
    int cam;
    Set<TreeNode> set;
    public int minCameraCover(TreeNode root) {
        set=new HashSet<>();
         cam=0;
         set.add(null);
         dfs(root,null);
         return cam;
    }
    public void dfs(TreeNode root,TreeNode parent){
        if(root!=null){
            dfs(root.left,root);
            dfs(root.right,root);

            //we will add the nodes to set that its node in set and also its left and right then increase the cmera
            if(parent==null && !set.contains(root)|| !set.contains(root.left)|| !set.contains(root.right)){
                cam++;
                set.add(root);
                set.add(root.left);
                set.add(root.right);
                set.add(parent);
            }
        }
    }
}
