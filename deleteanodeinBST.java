class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //it have 3 condition  either the leaf node or one node of the 2 node 
        //step 1 find the which side it lays 
        if(root==null){
            return null;
        }
      
        if(key<root.val){
            root.left=deleteNode(root.left,key);//lays in left part
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);//lays in right side
        }else{
            //node is found 
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

              // Node with two children: Get the inorder successor (smallest in the right subtree)
              TreeNode successor =inorderSuccessor(root.right);
              root.val=successor.val;
             root.right=deleteNode(root.right,successor.val);
        }
        return root;
    }
    //method to find the inorder succersor 
    public TreeNode inorderSuccessor(TreeNode root){
        //find the ,minimu in the node in  the right side of left node
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
