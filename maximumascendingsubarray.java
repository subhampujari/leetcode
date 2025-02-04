class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=nums[0];
        int curr=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
           if(nums[i-1]<nums[i]){
            curr+=nums[i];
            max=Math.max(max,curr);
           }else{
            curr=nums[i];
           }
        }
        return max;
    }
}