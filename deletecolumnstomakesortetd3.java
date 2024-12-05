class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        // dp[j] represents the length of the longest increasing subsequence of columns ending at column j
        int[] dp = new int[m];
        Arrays.fill(dp, 1);  // Each column itself can be a subsequence
        
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < j; i++) {
                // Check if column i can come before column j in the sequence
                boolean valid = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        // The length of the longest subsequence is the maximum value in dp
        int lis = 0;
        for (int len : dp) {
            lis = Math.max(lis, len);
        }
        
        // Minimum deletions = total columns - length of longest increasing subsequence
        return m - lis;
    }
}}
