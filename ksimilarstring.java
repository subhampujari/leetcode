class Solution {
    public int kSimilarity(String s1, String s2) {
       Queue<String> queue=new LinkedList<>();
      queue.add(s1);
      Map<String,Integer> map=new HashMap<>();
      map.put(s1,0);

      while(!queue.isEmpty()){
        String s=queue.poll();
        if(s.equals(s2))return map.get(s);
        for(String T:neighbiur(s,s2)){
            if(!map.containsKey(T)){
                map.put(T,map.get(s)+1);
                queue.add(T);
            }
        }
      }
      return -1;
    }
    public void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public List<String> neighbiur(String s,String t){
        List<String> res=new ArrayList<>();
        int i=0;
        while(s.charAt(i)==t.charAt(i))i++;

        char[] T=s.toCharArray();
        for(int j=i+1;j<s.length();++j){
            if(s.charAt(j)==t.charAt(i)){
                swap(T,i,j);
                res.add(new String(T));
                swap(T,i,j);
            }
        }
        return res;
    }
}