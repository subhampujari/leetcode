class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // For each letter a-z
        boolean isEndOfWord = false;

        // Get the index of the character
        private int getIndex(char c) {
            return c - 'a';
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = node.getIndex(c);
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public String searchShortestRoot(String word) {
            TrieNode node = root;
            StringBuilder result = new StringBuilder();
            for (char c : word.toCharArray()) {
                int index = node.getIndex(c);
                if (node.children[index] != null) {
                    result.append(c);
                    node = node.children[index];
                    if (node.isEndOfWord) {
                        return result.toString(); // Found a root
                    }
                } else {
                    break; // No further match in Trie
                }
            }
            return null; // No matching root found
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        // Insert all roots into the Trie
        for (String root : dictionary) {
            trie.insert(root);
        }

        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Replace words with their corresponding roots
        for (String word : words) {
            String root = trie.searchShortestRoot(word);
            if (root != null) {
                result.append(root).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        // Convert StringBuilder to String and trim the trailing space
        return result.toString().trim();
    }
}
