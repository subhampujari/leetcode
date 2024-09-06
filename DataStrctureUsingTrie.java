class WordDictionary {
    class TrieNode{
      TrieNode [] children;
      boolean eow;
      public TrieNode(){
       children=new TrieNode[26];
       eow=false;
      }
    } 
    private TrieNode root; 
   public WordDictionary() {
       root=new TrieNode();
   }
   
   public void addWord(String word) {
       TrieNode node=root;
       for(char c: word.toCharArray()){
           int index=c-'a';
           if(node.children[index]==null){
               node.children[index]=new TrieNode();
           }
        node=node.children[index];
       }
       node.eow=true;
   }
   
   public boolean search(String word) {
       return searchInTrie(word,root);
   }
   public boolean searchInTrie(String word,TrieNode node){
       if(word.isEmpty()){
           return node.eow;
       }

       char c=word.charAt(0);
       if(c=='.'){// if the char is dot then 
         for(TrieNode child: node.children){
           if(child!=null && searchInTrie(word.substring(1),child)){
               return true;
           }
         }
         return false;
       }else{// else then the char is except the dot
        int index=c-'a';
        TrieNode child=node.children[index];
        if(child==null){
           return false;
        }else{
           return searchInTrie(word.substring(1),child);
        }
       }
   }
}
