class Solution {
    public int uniqueLetterString(String s) {
         int n = s.length();
        final int MOD = 1000000007;
        
        // Create a list for each of the 26 characters (A-Z)
        List<Integer>[] hashmap = new ArrayList[26];
        
        // Initialize each list for each character
        for (int i = 0; i < 26; i++) {
            hashmap[i] = new ArrayList<>();
            hashmap[i].add(-1);  // Add -1 to represent the start position
        }
        
        // Store all indices of each character in the hashmap
        for (int i = 0; i < n; i++) {
            hashmap[s.charAt(i) - 'A'].add(i);
        }
        
        // Add the length of the string to represent the end position for each character
        for (int i = 0; i < 26; i++) {
            hashmap[i].add(n);
        }
        
        long count = 0;
        
        // Calculate the contribution of each character
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < hashmap[i].size() - 1; j++) {
                int prevIndex = hashmap[i].get(j - 1);
                int currIndex = hashmap[i].get(j);
                int nextIndex = hashmap[i].get(j + 1);
                
                // Calculate the number of unique substrings where `s.charAt(currIndex)` is unique
                count += (long) (currIndex - prevIndex) * (nextIndex - currIndex);
                count %= MOD;
            }
        }
        
        return (int) count;
    }
}
