class Solution {
    public int singleNumber(int[] nums) {
      /* int once=0;
       int second=0;
       for(int i:nums){//performin  xor bit manipulation
        once=~second & (once^i);
        second=~once & (second^i);
       }
       return once;
       */
       Arrays.sort(nums);
       for(int i=1;i<nums.length;i+=3){
        if(nums[i-1]!=nums[i]){
            return nums[i-1];
        }
       }
       return nums[nums.length-1];
    }
}
