class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //we can solve this question using the Bfs approach 
        List<List<Integer>> res=new ArrayList<>();
      if(root==null){//if the root is null then return the empty arrayalist
        return res;
      }
   Queue<Node> q=new LinkedList<>();//queue for BFS
   q.offer(root);//add the root into the queue
      while(!q.isEmpty()){
        int levelSize=q.size();
        List<Integer> level=new ArrayList<>();
        for(int i=0;i<levelSize;i++){
            Node node=q.poll();
            level.add(node.val);
            for(Node child:node.children){
                q.offer(child);//adding the child of the each root 
            }
        }
        res.add(level);
      }
      return res;
    }
}
