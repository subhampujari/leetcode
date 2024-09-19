class Solution {
    public char findTheDifference(String s, String t) {
         char result = 0; // Initialize result as 0 (null character)
        
        // XOR all characters from both strings
        for (char c : s.toCharArray()) {
            result ^= c; // XOR characters from s
        }
        for (char c : t.toCharArray()) {
            result ^= c; // XOR characters from t
        }
        
        return result; // The remaining character is the added one
    }
}
