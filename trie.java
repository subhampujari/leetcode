class Trie {
    class TreeNode{
     TreeNode[] childern;//Creat one Trie class with char array of 26 size and one boolean variable for end of the word
     boolean eow;
     public TreeNode(){
         childern=new TreeNode[26];
     }
    }
    private TreeNode root;
     public Trie() {
         root=new TreeNode();
     }
     
     public void insert(String word) {
         //for insertig the String we have to convert the word as char Array
         TreeNode node=root;
         for(char c:word.toCharArray()){
             int index=c-'a';//find the index of the word;
             if(node.childern[index]==null){
                 node.childern[index]=new TreeNode();
             }
             node=node.childern[index];// update the node
         }
         node.eow=true;// mark the end of the word as true 
     }
     
     public boolean search(String word) {
         TreeNode node=root;
         for(char c:word.toCharArray()){
             int index=c-'a';
             if(node.childern[index]==null){
                 return false;// if the index of the char is null return false
             }
             node=node.childern[index];
         }
         return node.eow;// after processing the end of word is true then return true or false
     }
     
     public boolean startsWith(String prefix) {
         TreeNode node=root;
         for(char c:prefix.toCharArray()){
             int index=c-'a';
             if(node.childern[index]==null){
                 return false;
             }
             node=node.childern[index];
         }
         return true;
     }
 }
 
