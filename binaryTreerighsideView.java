class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightRoot(root,0);
        return res;
    }
    public void rightRoot(TreeNode root,int depth){
        if(root==null)return;
        //if we are visting the node firt time add to the res
        if(depth==res.size()){
            res.add(root.val);
        }
        rightRoot(root.right,depth+1);
        rightRoot(root.left,depth+1);
    }
}
