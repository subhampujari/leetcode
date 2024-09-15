class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        // Fill the map with words and their indices
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        
        // Iterate through each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            
            // Try all possible splits of the word
            for (int j = 0; j <= len; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                
                // Check if prefix is a palindrome and suffix reversed is in the map
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (wordMap.containsKey(reversedSuffix) && wordMap.get(reversedSuffix) != i) {
                        result.add(List.of(wordMap.get(reversedSuffix), i));
                    }
                }
                
                // Check if suffix is a palindrome and prefix reversed is in the map
                // This avoids checking the same pair twice
                if (j != len && isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (wordMap.containsKey(reversedPrefix) && wordMap.get(reversedPrefix) != i) {
                        result.add(List.of(i, wordMap.get(reversedPrefix)));
                    }
                }
            }
        }
        
        return result;
    }

    // Helper function to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
    

