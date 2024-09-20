class Solution {
    public int longestSubstring(String s, int k) {
       /* return longestSubstringHelper(s, 0, s.length(), k);
    }
    
    private static int longestSubstringHelper(String s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        // Count the frequency of each character in the substring
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = start; i < end; i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Check if all characters meet the frequency requirement
        for (char c : charCount.keySet()) {
            if (charCount.get(c) < k) {
                // If a character does not meet the requirement, split the string
                int leftSubstringLength = longestSubstringHelper(s, start, s.indexOf(c, start), k);
                int rightSubstringLength = longestSubstringHelper(s, s.indexOf(c, start) + 1, end, k);
                return Math.max(leftSubstringLength, rightSubstringLength);
            }
        }
        
        // If all characters meet the requirement, return the length of the substring
        return end - start;
        */
         int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
      //  System.out.println(Arrays.toString(freq));

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < s.length() && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
            }
        }
        return s.length();
    }
}
