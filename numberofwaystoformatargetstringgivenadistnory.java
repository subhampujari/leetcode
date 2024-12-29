class Solution {
    public int numWays(String[] words, String target) {
        int n = words[0].length();  // Length of each word
        int m = target.length();    // Length of target
        int mod = 1000000007;       // Modulo value
        int dp[] = new int[m + 1];  // DP array to store results
        dp[0] = 1;  // There's one way to form an empty target

        // Create a 2D array `count` to store frequency of each character in each column of the words
        int[][] count = new int[n][26];  // 26 for each letter a to z
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;  // Increment count for the character in word[i]
            }
        }

        // Now, compute the DP table
        for (int i = 0; i < n; i++) {  // Iterate through each column of words
            for (int j = m - 1; j >= 0; j--) {  // Iterate through target backwards
                int targetIndex = target.charAt(j) - 'a';  // Get the index of the character in target
                dp[j + 1] = (dp[j + 1] + (int)((long)dp[j] * count[i][targetIndex] % mod)) % mod;  // Update DP
            }
        }

        return dp[m];  // The answer is the number of ways to form the whole target
    }
}
