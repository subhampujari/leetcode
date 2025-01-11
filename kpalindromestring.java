class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n<k)return false;
        int freqArray[]=new int[26];
        for(char ch:s.toCharArray()){
            freqArray[ch-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(freqArray[i]%2!=0){
                count++;
            }
        }
        return (count>k)?false:true;
    }
}
