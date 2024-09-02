class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2)return 0;
        int diff=0;// the differenc between two number
        int max=0;//the max number number differnec 
        Arrays.sort(nums);//sorting the arrayn..
        for(int i=0;i<nums.length-1;i++){
            diff=nums[i+1]-nums[i];// max diffrence
            max=Math.max(diff,max);/// maxmium diffrence between
        }
        return max;
    }
}