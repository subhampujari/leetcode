class Solution {
    public int maxProduct(int[] nums) {
    int leftSubarray=1;//leftProduct 
    int rightSubarray=1;//right product 
    int ans=nums[0];
    int n=nums.length;//length of the array 
  for(int i=0;i<n;i++){

    //edge case if any point the leftSubarray or rightSubarray is 0 then update it to 1
    leftSubarray=leftSubarray==0?1:leftSubarray;

    rightSubarray=rightSubarray==0?1:rightSubarray;

    //leftSubarray product 
    leftSubarray*=nums[i];

    //rightSubarray product
    rightSubarray*=nums[n-1-i];

    ans=Math.max(ans,Math.max(leftSubarray,rightSubarray));
  }
  return ans;
    }
}