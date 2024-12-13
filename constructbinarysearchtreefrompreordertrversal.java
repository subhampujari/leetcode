class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int index[]={0};
        return constructBST(preorder,index,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode constructBST(int[] preorder,int[] index,int lower,int upper){
        if(index[0]>=preorder.length)return null;

        int val=preorder[index[0]];

        if(val<lower || val>upper)return null;

        index[0]++;
        TreeNode node=new TreeNode(val);

        node.left=constructBST(preorder,index,lower,val);

        node.right=constructBST(preorder,index,val,upper);

        return node;
    }
}
