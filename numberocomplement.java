class Solution {
    public int findComplement(int num) {
       // we can solve this question using the bitmanipulation on bit mask
      int result = 0;
        int i = 0;
        
        while (num > 0) {
            // Corrected the condition with parentheses
            if ((num & 1) == 0) {
                result += (1 << i);
            }
            i += 1;
            num >>= 1;
        }
        
        return result;
    }
}