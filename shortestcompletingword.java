class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character,Integer> count=new HashMap<>();
        for(char c:licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                char lowercase=Character.toLowerCase(c);
                count.put(lowercase,count.getOrDefault(lowercase,0)+1);
            }
        }

        //cheking is the valid answer or not
        String validWord=null;

        for(String word:words){
            if(isCompletingWord(word,count)){
                if(validWord==null || word.length()<validWord.length()){
                    validWord=word;
                }
            }
        }
        return validWord;
    }
    public boolean isCompletingWord(String word,Map<Character,Integer> count){
         Map<Character,Integer> original=new HashMap<>();
          for(char c:word.toCharArray()){
                char lowercase=Character.toLowerCase(c);
                original.put(lowercase,original.getOrDefault(lowercase,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:count.entrySet()){
            char key=entry.getKey();
            int requriedCount=entry.getValue();
            if(original.getOrDefault(key,0)< requriedCount){
                return false;
            }
        }
        return true;
    }
}