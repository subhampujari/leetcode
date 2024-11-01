class Solution {
    public int deleteAndEarn(int[] nums) {
       if (nums == null || nums.length == 0) return 0;

        // Step 1: Find the maximum number in the input array
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Step 2: Create a frequency array
        int[] points = new int[maxNum + 1];
        for (int num : nums) {
            points[num] += num; // Sum points for each number
        }

        // Step 3: Use dynamic programming to calculate the maximum points
        int[] dp = new int[maxNum + 1];
        dp[0] = 0; // No points if we don't take anything
        dp[1] = points[1]; // Points for 1

        for (int i = 2; i <= maxNum; i++) {
            // Either take the current number or skip it
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        // The last element will hold the maximum points we can earn
        return dp[maxNum];
    }
}
