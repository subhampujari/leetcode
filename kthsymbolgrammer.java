class Solution {
    public int kthGrammar(int n, int k) {
      return helper(n, k - 1); // Convert k to 0-indexed
    }

    private int helper(int n, int k) {
        // Base case: the 1st row is always 0
        if (n == 1) {
            return 0;
        }
        
        // Find the middle index of the row
        int mid = (1 << (n - 1)) / 2; // This is 2^(n-2), the size of half the row
        
        if (k < mid) {
            // If k is in the first half, it follows the same value as in the previous row
            return helper(n - 1, k);
        } else {
            // If k is in the second half, it is the flipped value of the corresponding position
            return 1 - helper(n - 1, k - mid);
        }
    }
}
