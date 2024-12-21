class Solution {
    public int helper(int[] nums, int x, int y) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int sum = 0;

        // Calculate dp1 for subarrays of length x
        for (int i = 0; i < n; i++) {
            if (i < x) { // When we haven't considered a subarray of length x yet
                sum += nums[i];
                dp1[i] = sum;
            } else { // When we have a subarray of size x
                sum = sum + nums[i] - nums[i - x];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }

        sum = 0;
        // Calculate dp2 for subarrays of length y, checking from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (i + y > n - 1) { // Case when we haven't encountered a subarray of size y yet
                sum += nums[i];
                dp2[i] = sum;
            } else { // When we have a subarray of size y
                sum = sum + nums[i] - nums[i + y];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }

        // Now, find the maximum sum of non-overlapping subarrays
        int ans = 0;
        for (int i = x - 1; i < n - y; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }
        return ans;
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // We need to check two cases:
        // 1. firstLen comes before secondLen
        // 2. secondLen comes before firstLen
        return Math.max(helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen));
    }
}

