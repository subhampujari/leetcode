class Solution {
    public int minIncrementForUnique(int[] nums) {
          // Sort the array to easily detect duplicates
        Arrays.sort(nums);
        
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // If current number is not greater than the previous, we need to increment it
                moves += (nums[i - 1] + 1 - nums[i]);
                nums[i] = nums[i - 1] + 1; // Set nums[i] to be just greater than nums[i-1]
            }
        }
        
        return moves;
    }
}