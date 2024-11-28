class Solution {
    public int partitionDisjoint(int[] nums) {
       int n = nums.length;
        
        // Step 1: Prepare left_max and right_min arrays
        int[] left_max = new int[n];
        int[] right_min = new int[n];
        
        // Fill left_max array
        left_max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], nums[i]);
        }
        
        // Fill right_min array
        right_min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_min[i] = Math.min(right_min[i + 1], nums[i]);
        }
        
        // Step 2: Find the partition index
        for (int i = 0; i < n - 1; i++) {
            if (left_max[i] <= right_min[i + 1]) {
                return i + 1;
            }
        }
        
        return n;  // If no partition is found, the entire array is left.
    }
}
