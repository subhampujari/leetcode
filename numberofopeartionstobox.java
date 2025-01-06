class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        int balls=boxes.charAt(0) - '0';
        int left[]=new int[n];
        int right[]=new int[n];
        //left part
        for(int i=1;i<n;i++){
            left[i]+=left[i-1]+balls;
            balls+=boxes.charAt(i) - '0';
        }
        // right part
         balls=boxes.charAt(n-1) - '0';
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]+balls;
            balls+=boxes.charAt(i) - '0';
        }
        for(int i=0;i<n;i++){
            ans[i]=left[i]+right[i];
        }
        return ans;
    }
}
