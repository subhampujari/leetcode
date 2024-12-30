class Solution {
    public int longestStrChain(String[] arr) {
         if (arr == null || arr.length == 0) return 0;
         if(arr.length==1)return 1;

        // Sort the strings by their lengths, not lexicographically
        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        int n = arr.length;
        int[] dp = new int[n]; // dp[i] represents the longest chain ending at arr[i]

        // Initially, each string is a chain of length 1
        Arrays.fill(dp, 1);
        
        int max = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Only check strings where arr[i] is one character longer than arr[j]
                if (compareAndCheck(arr[i], arr[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Helper method to check if s1 is formed by removing exactly one character from s2
    public  boolean compareAndCheck(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        
        int i = 0, j = 0;
        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++; // Skip one character from s1
            }
        }
        return j == s2.length(); // j should have traversed all characters in s2
    }
}