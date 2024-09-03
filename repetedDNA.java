class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
   
   /*   // we can simply solve this question using one hasMap
      Map<String,Integer> map=new HashMap<>();//
      for(int i=0;i<s.length()-9;i++){
        String str=s.substring(i,i+10);// put all the substringo of 1 to 10 latters
        map.put(str,map.getOrDefault(str,0)+1);
      }
    List<String> res=new ArrayList<>();
    for(Map.Entry<String,Integer> e:map.entrySet()){
        if(e.getValue()>1){
            res.add(e.getKey());// add to the list wich occur more than one time
        }
    }
    return res;
    */
    Set<String> hs = new HashSet<>();
        Set<String> visited = new HashSet<>();
        List<String> res=new ArrayList<>();
        if(s.length()<=10 || s.length()>10000){
            return res;
        }
        for(int i=0; i<=s.length()-10; i++){
            String sb = s.substring(i, i+10);           
            if(!visited.add(sb)){
                hs.add(sb);
            }
        }
        
        res.addAll(hs);
        
        return res;
    }
}
