class Solution {
    public String reorganizeString(String s) {
        //store the frequency of each charcter
        Map<Character,Integer> fmap=new HashMap<>();
        for(char c:s.toCharArray()){
            fmap.put(c,fmap.getOrDefault(c,0)+1);
        }

        //add into the priorotiy queue 
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->fmap.get(b)-fmap.get(a));
        for(char c:fmap.keySet()){
            maxHeap.add(c);
        }

        if(fmap.get(maxHeap.peek())> (s.length()+1)/2){
            return "";//empty string 
        }
        StringBuilder sb=new StringBuilder();

        while(maxHeap.size()>1){
           char first=maxHeap.poll();
           char second=maxHeap.poll();
             
              sb.append(first);
              sb.append(second);

         fmap.put(first,fmap.get(first)-1);
         fmap.put(second,fmap.get(second)-1);



              if(fmap.get(first)>0){
                maxHeap.add(first);
              }
              if(fmap.get(second)>0){
                maxHeap.add(second);
              }
        }
        if(!maxHeap.isEmpty()){
            sb.append(maxHeap.poll());
        }
        return sb.toString();
    }
}