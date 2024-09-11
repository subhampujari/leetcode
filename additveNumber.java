import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
     /* int n = num.length();
        for (int i = 1; i < n - 1; ++i) {
            // Skip invalid sequences with leading zeros
            if (num.charAt(0) == '0' && i > 1) return false;
            for (int j = i + 1; j < n; ++j) {
                if (num.charAt(i) == '0' && j - i > 1) break;

                // Convert substrings to BigInteger
                BigInteger num1 = new BigInteger(num.substring(0, i));
                BigInteger num2 = new BigInteger(num.substring(i, j));
                if (isValid(num1, num2, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(BigInteger num1, BigInteger num2, int start, String num) {
        if (start == num.length()) return true;

        // Calculate the next number in the sequence
        BigInteger sum = num1.add(num2);

        // Convert the next number to string
        String sumStr = sum.toString();

        // Check if the remaining string starts with the next number
        if (num.startsWith(sumStr, start)) {
            return isValid(num2, sum, start + sumStr.length(), num);
        }

        return false;
        */
         return backtrack(num, 0, 0, 0, 0);
    }
    
    public boolean backtrack(String num, int idx, long sum, long prev, int length){
        if (idx == num.length()) {
            return length >= 3;
        }
        
        long currLong = 0;
        
        for (int i = idx; i < num.length(); i++) {
            if (i > idx && num.charAt(idx) == '0') {
                break;
            }
            currLong = currLong * 10 + num.charAt(i) - '0';
            
            if (length >= 2) {
                if(sum < currLong) {
                    break;
                }
                else if(sum > currLong) {
                    continue;
                }
            }

            if (backtrack(num, i + 1, currLong + prev, currLong, length + 1) == true) {
                return true;
            }
        }
        return false;
    }
}