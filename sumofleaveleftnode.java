class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int sum=0;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){//cheking if the node is left leaf then add the value
                if(node.left.left==null && node.left.right==null){
                    sum+=node.left.val;
                }else{
                    q.offer(node.left);//else add the node into the queue
                }
            }

            if(node.right!=null){
                q.offer(node.right);//add the right node is it is not null
            }
        }
        return sum;
    }
}