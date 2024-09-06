class Solution {
    public String shortestPalindrome(String s) {
       int n=s.length();
       int left=0;
       //cheking front to end for the shortetst palindrom
       for(int right=n-1;right>=0;right--){
        if(s.charAt(left)==s.charAt(right)){
         left++;
        }
       }
       //return the string if already is palindrom
       if(left==n)return s;
//creating suffix string of string 
  String suffix=s.substring(left,n);
  //creating the prefix string from to start to left;
  String prfix=shortestPalindrome(s.substring(0,left));
  //append the reverse of suffix then the prix then the suffix ..
  return new StringBuffer(suffix).reverse().append(prfix).append(suffix).toString();
    }
}
