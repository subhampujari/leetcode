class Solution {
    public int numDecodings(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }

        long[] dp = new long[s.length() + 1];
        dp[0] = 1; // base case: empty string
        dp[1] = decodeChar(s.charAt(0));

        // explore for the next dp values 
        for (int i = 2; i <= s.length(); i++) {
            char oneChar = s.charAt(i - 1);
            char twoChar = s.charAt(i - 2);

            dp[i] += dp[i-1] *decodeChar(oneChar);
            dp[i] += dp[i-2]*decodeTwoChar(twoChar, oneChar);
            dp[i] %= 1000000007; // to avoid overflow
        }

        return (int) dp[s.length()];
    }

    public int decodeChar(char first) {
        if (first == '*') {
            return 9; // '*' can represent 1-9
        } else if (first == '0') {
            return 0; // '0' cannot be decoded
        }
        return 1; // any other character (1-9) can be decoded as one character
    }

    public int decodeTwoChar(char first, char second) {
        if (first == '*') {
            if (second == '*') {
                return 15; // '**' can represent 11-19 and 21-26
            } else if (second >= '0' && second <= '6') {
                return 2; // '1*' or '2*' can represent 11-16 or 21-26
            } else {
                return 1; // '1*' or '2*' can only represent 10-19 or 21-26
            }
        } else if (first == '1') {
            if (second == '*') {
                return 9; // '1*' can represent 11-19
            } else {
                return 1; // '1X' where X is 0-9
            }
        } else if (first == '2') {
            if (second == '*') {
                return 6; // '2*' can represent 21-26
            } else if (second >= '0' && second <= '6') {
                return 1; // '2X' where X is 0-6
            } else {
                return 0; // '2X' where X is 7-9
            }
        }
        return 0; // any other cases
    }
}