class Solution {
    public int maxEnvelopes(int[][] envelopes) {
     if(envelopes.length==0 || envelopes[0].length==0 || envelopes==null)return 0;
      //sort the array using the compartor 
      //sort the array in increasing of width
      //sort that by decresing the height order if the width are not equal
     Arrays.sort(envelopes, new  Comparator<int[]>(){
        public int compare(int[]a,int[]b){
        if(a[0]!=b[0]){
            return a[0]-b[0];//sort in incersing order
        }else{
            return b[1]-a[1];//sort on decresing order
        }
        }
     });

     int dp[]=new int[envelopes.length+1];
     int len=0;
     int idx=0;
     Arrays.fill(dp,Integer.MAX_VALUE);
     dp[0]=0;//first should be zero

     for(int i=0;i<envelopes.length;i++){
        idx=Arrays.binarySearch(dp,envelopes[i][1]);
        idx=idx < 0 ?-1-idx:idx;
        dp[idx]=envelopes[i][1];
        len=Math.max(len,idx);
     }
     return len;
    }
}
