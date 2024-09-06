class Solution {
    private TrieNode root;
    private Set<String> st;
    //trie implements 
   class TrieNode{
     Map<Character,TrieNode>children;
       String word;
       public TrieNode(){
           children=new HashMap<>();
           word=null;
       }
   }
   //class construtor 
      public Solution(){
       root=new TrieNode();
       st=new HashSet<>();
      }
//add method in the trie
   public void addWord(String word){// adding to the trie 
       TrieNode node=root;
       for(char c:word.toCharArray()){
           int index=c-'a';
           if(!node.children.containsKey(c)){
               node.children.put(c,new TrieNode());
           }
         node = node.children.get(c);
       }
       node.word=word;
   }
   //dfs trversal for the trie
   public void dfs(int i,int j,char[][] board,TrieNode node){
  int m=board.length;
  int n=board[0].length;

  if(i < 0 || i>=m  || j < 0 || j>=n)return;

  char c=board[i][j];// finding the character
  TrieNode nextNode = node.children.get(c);

       if (nextNode == null) return; // No matching prefix

       // Check if the current node contains a valid word
       if (nextNode.word != null) {
           st.add(nextNode.word);
           nextNode.word = null; // Avoid duplicate entries
       }

       // Mark the cell as visited by replacing it with a special character
       board[i][j] = '#';

       // Explore neighbors
       dfs(i - 1, j, board,nextNode); // Up
       dfs(i + 1, j, board, nextNode); // Down
       dfs(i, j - 1,  board,nextNode); // Left
       dfs(i, j + 1, board, nextNode); // Right

       // Unmark the cell (backtrack)
       board[i][j] = c;
   }

   public List<String> findWords(char[][] board, String[] words) {
       int m=board.length;
       int n=board[0].length;
      
      for(String word:words){
       addWord(word);// add to the trie
      }
     

     //explore for verstacl amd horizently
     for(int i=0;i<m;i++){
       for(int j=0;j<n;j++){
           dfs(i,j,board,root);
       }
     }
return new ArrayList<>(st);
   }
}
