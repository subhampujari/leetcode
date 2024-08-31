class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=new ArrayList<>();
        if(wordDict.contains(s))
            result.add(s);
        
    //exploring alll the next substring ]

    for(int i=1;i<=s.length();i++){
        String left=s.substring(0,i);
        if(wordDict.contains(left)){
            List<String> sublist=wordBreak(s.substring(i),wordDict);
            for(String sen:sublist){
                result.add(left+" "+sen);
            }
        }
        
    }
    return result;
    }
}