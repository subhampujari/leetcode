class Solution {
    public int distributeCoins(TreeNode root) {
        int move[]=new int[1];
        dfs(root,move);
        return move[0];
    }
    public int dfs(TreeNode node,int []move){
        if(node==null)return 0;

        int left=dfs(node.left,move);
        int right=dfs(node.right,move);

        move[0]+=Math.abs(left)+Math.abs(right);
        return node.val+left+right-1;
    }
}