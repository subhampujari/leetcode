class Solution {
    public List<String> commonChars(String[] words) {
        int arr1[]=new int[26];
        String word=words[0];
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            arr1[index]++;
        }
         int n=words.length;
        for(int i=1;i<n;i++){
             String currWord=words[i];
             int arr2[]=new int[26];
             for(char ch:currWord.toCharArray()){
            int index=ch-'a';
            arr2[index]++;
        }
        for(int j=0;j<26;j++){
            arr1[j]=Math.min(arr1[j],arr2[j]);
        }
        }

        List<String> res=new ArrayList<>();
        for(int j=0;j<26;j++){
            if(arr1[j]!=0){
                char ch=(char)(j+97);
                int count=arr1[j];
                while(count!=0){
                    res.add(""+ch);
                    count--;
                }
            }
        }
        return res;
    }
}