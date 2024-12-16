class Solution {
    public boolean queryString(String s, int n) {
      for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            if (!s.contains(binary)) { // Check if EACH binary string is present
                return false; // If any is missing, return false immediately
            }
        }
        return true; // All binary strings were found
    }
}
