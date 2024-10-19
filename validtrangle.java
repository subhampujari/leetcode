class Solution {
    public int triangleNumber(int[] nums) {
        // Sort the array to apply the triangle condition
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        // Iterate over each element as the longest side
        for (int k = 2; k < n; k++) {
            int i = 0; // First pointer
            int j = k - 1; // Second pointer

            // Use two pointers to find valid pairs
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // If nums[i] + nums[j] > nums[k], all pairs (i, i+1, ..., j-1) with j are valid
                    count += (j - i);
                    j--; // Move the second pointer to the left
                } else {
                    i++; // Move the first pointer to the right
                }
            }
        }

        return count;
    }
}