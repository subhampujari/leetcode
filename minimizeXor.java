class Solution {
    public int minimizeXor(int num1, int num2) {
        int res = 0;
        int targetCount = Integer.bitCount(num2);  // Count of 1's in num2
        for (int i = 31; i >= 0 && targetCount > 0; i--) {
            if ((num1 & (1 << i)) != 0) {  // Check if the ith bit in num1 is 1
                res |= (1 << i);  // Set the ith bit in result
                targetCount--;  // Decrease the remaining count of 1's to set
            }
        }
        
        // If there are still bits to set (targetCount > 0), set them from the lower bits
        for (int i = 0; i < 32 && targetCount > 0; i++) {
            if ((res & (1 << i)) == 0) {  // If the ith bit in res is not set
                res |= (1 << i);  // Set the ith bit in result
                targetCount--;  // Decrease the remaining count of 1's to set
            }
        }

        return res;
    }
}
