class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1)return 1;
  int n=nums.length;
  int []dp=new int[n];
  int maxLength=0;
  Arrays.fill(dp,1);
  for(int i=1;i<n;i++){
    for(int j=0;j<i;j++){
        if(nums[i]>nums[j]){
            dp[i]=Math.max(dp[i],dp[j]+1);
        }
    }
    maxLength=Math.max(dp[i],maxLength);
  }
return maxLength;
    }
}
