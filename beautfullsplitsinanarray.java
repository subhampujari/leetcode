class Solution {
    public int beautifulSplits(int[] nums) {
        final int n = nums.length;
        final int[][] dp = new int[n][n];

        // Fill the DP array to store the length of the common prefix between subarrays
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] == nums[j]) {
                    dp[i][j] = 1 + (j > i + 1 && j + 1 < n ? dp[i + 1][j + 1] : 0);
                }
            }
        }

        int result = 0;

        // Iterate through possible splits
        for (int i = n - 2; i > 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // Check if nums1 is a prefix of nums2 or nums2 is a prefix of nums3 using DP array
                boolean firstCondition = (j - i >= i) && (dp[0][i] >= i);
                boolean secondCondition = (j - i <= n - j) && (dp[i][j] >= j - i);

                if (firstCondition || secondCondition) {
                    result++;
                }
            }
        }

        return result;
    }
}
