public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeString(root,sb);
        return sb.toString();
    }
public void  serializeString(TreeNode root,StringBuilder sb){
    if(root==null){
        sb.append("null,");
        return;// i have used the preorder travesal technique to solve it 
    }
   sb.append(root.val).append(",");
     serializeString(root.left,sb);
      serializeString(root.right,sb);

}
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
        int[] index={0};
        return deserizaibleNode(nodes,index);
    }
    public TreeNode deserizaibleNode(String[] nodes, int[] index){
     //base case
     if(index[0] >= nodes.length || nodes[index[0]].equals("null")){
        index[0]++;//move to the nex step
        return null;
     }
      TreeNode node=new TreeNode(Integer.parseInt(nodes[index[0]]));
      index[0]++;

      //exploer the next left and right partt of the tree
      node.left=deserizaibleNode(nodes,index);
      node.right=deserizaibleNode(nodes,index);
      return node;

    }
}
