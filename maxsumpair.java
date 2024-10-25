class MapSum {
    class TrieNode{
        Map<Character,TrieNode> children;
        int sum;
    
           TrieNode(){
            children=new HashMap<>();
            sum=0;
           }
    }
    private TrieNode root;
        private Map<String, Integer> keyValueMap;
        public MapSum() {
            root=new TrieNode();
            keyValueMap=new HashMap<>();
        }
        
        public void insert(String key, int val) {
            //get the preious value if exist 
            int delta=val;
            if(keyValueMap.containsKey(key)){
                delta-=keyValueMap.get(key);//calulate change in the cval
            }
    
            keyValueMap.put(key,val);
            TrieNode currNode=root;
    
            for(char c:key.toCharArray()){
                if(!currNode.children.containsKey(c)){
                    currNode.children.put(c,new TrieNode());
                }
                currNode=currNode.children.get(c);
                currNode.sum+=delta;//ad the differnce into the char 
            }
        }
        
        public int sum(String prefix) {
            TrieNode currNode=root;
    
            for(char c:prefix.toCharArray()){
                if(!currNode.children.containsKey(c)){
                    return 0;
                }
                currNode=currNode.children.get(c);
            }
            return currNode.sum;//after the end of string return the sum
        }
    }
    
