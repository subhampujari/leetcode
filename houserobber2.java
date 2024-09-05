class Solution {
    public int rob(int[] nums) {
        //to solve this question we can use the DP
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        int n=nums.length;
        // from 0 to n-1 of array 
        int max1=MaxRobber(Arrays.copyOfRange(nums,0,n-1));
        //form 1 to n;
        int max2=MaxRobber(Arrays.copyOfRange(nums,1,n));

        //return the maximum among theboth
        return Math.max(max1,max2);
    }
    public int MaxRobber(int[] nums){
        int prev1=0;
        int prev2=0;
        for(int i:nums){
            int temp=Math.max(prev1+i,prev2);
            prev1=prev2;
            prev2=temp;
        }
        return prev2;
    }
}
