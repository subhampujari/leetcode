class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            // Remove the current word from the set and check if it can be formed
            wordSet.remove(word);
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            // Add the word back to the set for future checks
            wordSet.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (word.isEmpty()) return false; // We can't form an empty word
        int length = word.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true; // Base case: empty string can be formed

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid split, no need to check further
                }
            }
        }

        // Ensure the last entry is true and at least two words were used
        return dp[length];
    }
