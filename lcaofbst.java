class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int RootVal=root.val;
        int pVal=p.val;
        int qVal=q.val;
       //if(the q and p val is gretaer then the root val then we move towards the rightSide ogff the tree)
        if(pVal>RootVal && qVal>RootVal){
           return  lowestCommonAncestor(root.right,p,q);
//else we move towards the left of the tree
        }else if(pVal<RootVal && qVal<RootVal){
            return lowestCommonAncestor(root.left,p,q);
    }else{//otherWise if both are not satisfay we return the root node
        return root;
    }
    }
}
