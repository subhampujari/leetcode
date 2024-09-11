public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }
public void serializeHelper(TreeNode root,StringBuilder sb ){
    if(root==null){
        sb.append("null,");// if the root is null then add into the string as null
        return ;
    }
    sb.append(root.val).append(",");// append the root value and with the ne comma
    serializeHelper(root.left,sb);// left subtree
    serializeHelper(root.right,sb);//right subtree...
}
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
       Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
       return desrizablehelper(queue);

    }
    public TreeNode desrizablehelper(Queue<String> queue){
         String data=queue.poll();
         if(data.equals("null")){// if the string is the null hen we simply add the root as null
            return null;
         }
         TreeNode root=new TreeNode(Integer.parseInt(data));// creating thenode of the node of the value 
         root.left=desrizablehelper(queue);//leftsubtree of the root
         root.right=desrizablehelper(queue);//right subtree of the root 
         return root;
    }
}

