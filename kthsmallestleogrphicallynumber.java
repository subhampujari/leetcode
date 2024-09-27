class Solution {
    public int findKthNumber(int n, int k) {
         int current = 1; // Start with the smallest lexicographical number
        k--; // Since we're using 0-based index
        
        while (k > 0) {
            int count = getCount(n, current);
            if (count <= k) {
                // If there are less than or equal to k numbers, go to the next prefix
                current++;
                k -= count; // Decrease k by the count of numbers skipped
            } else {
                // If count > k, move down the tree
                current *= 10; // Move to the next level (current digit)
                k--; // We used one number (the current one)
            }
        }
        
        return current;
    }

   private int getCount(int n, int prefix) {
        long cur = prefix;
        long next = prefix + 1;
        int count = 0;
        
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur; // Count numbers in the current range
            cur *= 10; // Move to the next level
            next *= 10; // Move the next prefix to the next level
        }
        
        return count;
    }
    
}
