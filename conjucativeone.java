class Solution {
    public int findIntegers(int n) {
       // Create the dp array to store Fibonacci values
        int[] dp = new int[32]; // Maximum bits for an integer in the range
        dp[0] = 1; // There's 1 valid number for 0 bits (the number 0)
        dp[1] = 2; // There are 2 valid numbers for 1 bit (0 and 1)
        
        // Fill the dp array based on the Fibonacci relationship
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int prevBit = 0; // To track the previous bit
        int count = 0; // To count the valid integers
        
        for (int i = 31; i >= 0; i--) {
            // Check if the i-th bit is set in n
            if ((n & (1 << i)) != 0) {
                count += dp[i]; // Add the count of valid numbers for this bit position
                
                // If the previous bit is also set, we stop since it would create consecutive ones
                if (prevBit == 1) {
                    return count; // Early return
                }
                
                prevBit = 1; // Mark the current bit as set
            } else {
                prevBit = 0; // Reset prevBit since the current bit is not set
            }
        }
        
        // Include n itself if it has no consecutive ones
        return count + 1; // Include n itself as a valid number
    }

