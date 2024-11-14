class Solution {
    public int minimumLengthEncoding(String[] words) {
       // Sort the words by length in descending order to ensure we handle the largest words first
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        // A set to store the encoded words
        Set<String> uniqueWords = new HashSet<>();

        // Iterate over all words
        for (String word : words) {
            // Add word to the set only if it's not already a suffix of an existing word
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            boolean isSuffix = false;
            for (String encodedWord : uniqueWords) {
                if (encodedWord.startsWith(reversedWord.toString())) {
                    isSuffix = true;
                    break;
                }
            }
            if (!isSuffix) {
                uniqueWords.add(reversedWord.toString());
            }
        }

        // The length of the reference string will be the sum of all unique words' lengths + 1 for each '#'
        int totalLength = 0;
        for (String word : uniqueWords) {
            totalLength += word.length() + 1; // +1 for the '#'
        }

        return totalLength;
    }
}
