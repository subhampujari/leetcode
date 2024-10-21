class Solution {
    public int countSubstrings(String s) {
       int count=0;
       //expend the next string palindrome
       int n=s.length();
       for(int i=0;i<n;i++){
        count+=expandString(s,i,i);//for the odd case

        count+=expandString(s,i,i+1);
       } 
       return count;
    }
    public int expandString(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            right++;
            left--;
        }
        return count;
    }
}
