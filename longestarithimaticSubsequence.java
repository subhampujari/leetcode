class Solution {
    public int longestArithSeqLength(int[] nums) {
           int n = nums.length;
        if (n <= 1) return n;

        // dp[i] stores a map where the key is the common difference and the value is the length of the longest subsequence
        // ending at index i with that difference
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int max = 0;

        // Iterate over each pair of indices (i, j) where i > j
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                // If we already have a subsequence with this common difference ending at index j
                // it means we can extend that subsequence by adding nums[i]
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
