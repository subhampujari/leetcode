import java.math.BigInteger;
class Solution {
    public String smallestGoodBase(String n) {
     long tn = Long.parseLong(n);
        
        // Start from the highest possible exponent
        for (int i = 62; i >= 1; i--) {
            long base = mySolve(tn, i);
            if (base != 0) {
                return Long.toString(base);
            }
        }
        
        // If no base was found, return n-1
        return Long.toString(tn - 1);
    }
   private long mySolve(long n, int d) {
        long left = 2; // The smallest base greater than 1
        long right = (long) Math.pow(n, 1.0 / d) + 1; // Upper bound for base
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 1;
            long curr = 1;
            
            // Calculate the sum of powers
            for (int i = 0; i < d; i++) {
                curr *= mid; // Calculate mid^i
                sum += curr;
            }
            
            if (sum == n) {
                return mid; // Found a valid base
            } else if (sum < n) {
                left = mid + 1; // Increase base
            } else {
                right = mid - 1; // Decrease base
            }
        }
        
        return 0; // No valid base found
    }
}
