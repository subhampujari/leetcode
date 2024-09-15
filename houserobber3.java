class Solution {
    public int rob(TreeNode root) {
        // we can solv this question using the DFS approach with the DP
        int [] maximurob=dfs(root);
        return Math.max(maximurob[0], maximurob[1]);
    }
    public int[] dfs(TreeNode root){
        if(root==null)return new int[2];//if the null then return a empty size 2 array

        int[] left=dfs(root.left);//leftpart of tree
        int[] right=dfs(root.right);//right part of the array 

        int  ifrob=root.val+left[1]+right[1];//if we want to rob the node and dont want to rob the childern
        int notrob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);//if we dont want to tob the node and want to rub the childern
        return new int[]{ifrob,notrob};
    }
}
