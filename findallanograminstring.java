class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // to solve this question we can use the map data structure 
        List<Integer> res=new ArrayList<>();
         
         //base case
         if(s.length()<p.length()){
            return res;
         }
        //stroring the frewuwncy of p string in the map
        HashMap<Character,Integer> pMap=new HashMap<>();
        for(char c:p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }

        //adding the frequency of  1st window of s string of p length in the map \
        HashMap<Character,Integer> sMap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
        }

        //cheking if the first window is the same or angram then add into the result
        if(sMap.equals(pMap)){
            res.add(0);
        }

         //exploring the next window 
         for(int i=p.length();i<s.length();i++){
            //finding the new charcter 
            char newChar=s.charAt(i);
            //finding the old char 
            char oldChar=s.charAt(i-p.length());
            
            //adding the newchar to the map
            sMap.put(newChar,sMap.getOrDefault(newChar,0)+1);

            //removing the oldchar from the map
            if(sMap.get(oldChar)==1){
                sMap.remove(oldChar);
            }else{
                sMap.put(oldChar,sMap.get(oldChar)-1);
            }
//after removing the oldchar cheking if the window is angram then add into the result 
         if(sMap.equals(pMap)){
            res.add(i-p.length()+1);
         }
         }
return res;
    }
}
