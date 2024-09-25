class Solution {
    public int characterReplacement(String s, int k) {
         int left=0;//left pointer of the window
         int maxCount=0;//findng the maximum frequency of a chacter in the string
         int maxLength=0;//finding the maximum substring 
         int []count=new int[26];//storing the frequncy of each chracter

         for(int right=0;right<s.length();right++){
            //increasing the frequency of chacrter in the array
            count[s.charAt(right)-'A']++;
            //incresase the maximum frequent of chrcter in the string
            maxCount=Math.max(maxCount,   count[s.charAt(right)-'A']);

            //find the substring  if the window goes out of range of k then we shirnk the window from left
            while(right-left+1-maxCount>k){
                   count[s.charAt(left)-'A']--;//decrese the frequency
                   left++;//increase the left pointer
            }

            //increase the maximum substring
            maxLength=Math.max(maxLength,right-left+1);
         }
         return maxLength;
    }
}