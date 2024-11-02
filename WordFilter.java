/*class WordFilter {
 private Map<String, Integer> prefixSuffixMap;
    public WordFilter(String[] words) {
          prefixSuffixMap = new HashMap<>();
        int n = words.length;

        // Populate the map with all prefixes and suffixes
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int wordLength = word.length();

            // Generate all combinations of prefixes and suffixes
            for (int j = 0; j <= wordLength; j++) {
                for (int k = 0; k <= wordLength; k++) {
                    String prefix = word.substring(0, j); // Prefix of length j
                    String suffix = word.substring(wordLength - k); // Suffix of length k
                    String key = prefix + "#" + suffix; // Combine prefix and suffix
                    prefixSuffixMap.put(key, i); // Store the index
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
          String key = pref + "#" + suff; // Create the key for lookup
        return prefixSuffixMap.getOrDefault(key, -1); // Return the index or -1 if not found
    }
}
*/
class TrieNode {
    TrieNode[] children;
    int index;

    public TrieNode() {
        children = new TrieNode[26]; // For lowercase English letters
        index = -1; // To store the index of the word
    }
}

public class WordFilter {
    private TrieNode prefixTrie;
    private TrieNode suffixTrie;

    public WordFilter(String[] words) {
        prefixTrie = new TrieNode();
        suffixTrie = new TrieNode();
        
        int n = words.length;

        // Insert each word into both Tries
        for (int i = 0; i < n; i++) {
            String word = words[i];

            // Insert into prefix Trie
            insertIntoTrie(prefixTrie, word, i);
            
            // Insert into suffix Trie (insert reversed word)
            insertIntoTrie(suffixTrie, new StringBuilder(word).reverse().toString(), i);
        }
    }

    private void insertIntoTrie(TrieNode root, String word, int index) {
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            if (root.children[charIndex] == null) {
                root.children[charIndex] = new TrieNode();
            }
            root = root.children[charIndex];
            root.index = index; // Store the index of the word at this node
        }
    }

    public int f(String pref, String suff) {
        // Search for prefix
        TrieNode prefixNode = searchPrefix(prefixTrie, pref);
        // Search for suffix
        TrieNode suffixNode = searchPrefix(suffixTrie, new StringBuilder(suff).reverse().toString());
        
        // If either search fails, return -1
        if (prefixNode == null || suffixNode == null) {
            return -1;
        }

        // Check the index stored in the prefix node and the suffix node
        // We want the largest index from the valid words
        return Math.max(prefixNode.index, suffixNode.index);
    }

    private TrieNode searchPrefix(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            if (root.children[charIndex] == null) {
                return null; // Prefix not found
            }
            root = root.children[charIndex];
        }
        return root; // Return the node corresponding to the last character
    }
}