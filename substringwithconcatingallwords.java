class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //if the String or words length is null or not containg any words then return empty linkedlist
       if(s.length()==0||s==null||words.length==0||words==null)return new ArrayList<>();
       Map<String,Integer> map=new HashMap<>();
       for(String word:words){
        map.put(word,map.getOrDefault(word,0)+1);//put all the word of Striing in map
       }
       List<Integer> res=new ArrayList<>();
       int wLength=words[0].length();//Each length String in word array
       int slength=s.length();//string length
       int twLength=words.length;//total Striing array length
       for(int i=0;i<slength-wLength*twLength+1;i++){
        String subString=s.substring(i,wLength*twLength+i);//substring which of word length
        HashMap<String,Integer> seen=new HashMap<>();
        for(int j=0;j<subString.length();j+=wLength){
            String substr=subString.substring(j,wLength+j);//string of the each word length
            seen.put(substr,seen.getOrDefault(substr,0)+1);//add in to the map 
        }
        if(seen.equals(map))res.add(i);//cheking if the word of seen and map is equal then add the index 
       }
       return res;
    }
}