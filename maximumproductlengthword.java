class Solution {
    public int maxProduct(String[] words) {
     // to solve this question use the bit manipulation
        int n=words.length;
        int bitmask[]=new int[n];
        int length[]=new int[n];
       //Step 1: Compute bitmasks and lengths for each word
       for(int i=0;i<n;i++){
        int bit=0;
        for(char c:words[i].toCharArray()){
          bit |=1 << (c-'a');//find the each bitmask
        }
        bitmask[i]=bit;
        length[i]=words[i].length();
       }

       //step 2 to find the max length of the word in the array  using the bitwise and operastor 
      int maxLength=0;
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if((bitmask[i] & bitmask[j])==0){
                maxLength=Math.max(maxLength,length[i]*length[j]);
            }
        }
       }
       return maxLength;
    }
}
