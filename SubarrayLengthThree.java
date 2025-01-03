class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        int left=0;
        for(int right=2;right<nums.length;right++){
            if((nums[left]+nums[right])==(nums[left+1]/2) && (nums[left+1]%2==0)){//cheking for both even and half rule
                count++;
            }
            left++;
        }
        return count;
    }
}
