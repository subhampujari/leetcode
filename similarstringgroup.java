class Solution {
    public int numSimilarGroups(String[] strs) {
         int n = strs.length;
        boolean[] visited = new boolean[n];
        int groupCount = 0;
        
        // DFS function to explore all connected strings from a starting string
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Start a DFS from the unvisited string
                dfs(strs, visited, i);
                groupCount++;
            }
        }
        
        return groupCount;
    }
      // Helper function to check if two strings are similar
    public static boolean areSimilar(String str1, String str2) {
        if (str1.equals(str2)) {
            return true; // Identical strings are always similar
        }
        
        // Collect positions where the strings differ
        int[] diffIndices = new int[2];
        int diffCount = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (diffCount == 2) {
                    return false; // More than two differences, so not similar
                }
                diffIndices[diffCount++] = i;
            }
        }
        
        // If exactly two positions differ, check if swapping them makes the strings equal
        return diffCount == 2 && str1.charAt(diffIndices[0]) == str2.charAt(diffIndices[1]) &&
               str1.charAt(diffIndices[1]) == str2.charAt(diffIndices[0]);
    }
    // DFS to visit all strings in the same group
    private static void dfs(String[] strs, boolean[] visited, int index) {
        visited[index] = true;
        
        // Compare the current string with every other unvisited string
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i] && areSimilar(strs[index], strs[i])) {
                dfs(strs, visited, i);
            }
        }
    }
}