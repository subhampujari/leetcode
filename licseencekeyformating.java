class Solution {
    public String licenseKeyFormatting(String s, int k) {
      // Step 1: Remove all the '-' and convert to uppercase
        StringBuilder sb = new StringBuilder(s.replaceAll("-", "").toUpperCase());
        StringBuilder res = new StringBuilder();
        int n = sb.length();
        
        // Step 2: Reverse the string to facilitate formatting
        sb.reverse();

        // Step 3: Build the result
        for (int i = 0; i < n; i += k) {
            if (i + k < n) {
                res.append(sb.substring(i, i + k));
            } else {
                res.append(sb.substring(i));
            }
            if (i + k < n) {
                res.append("-");
            }
        }

        // Step 4: Reverse the result before returning
        return res.reverse().toString();
    }
}
