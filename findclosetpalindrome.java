class Solution {
    public String nearestPalindromic(String n) {
         List<Long> list = new ArrayList<>();
        int len = n.length();
        int mid = (len % 2 == 0) ? (len / 2) : (len / 2 + 1);
        boolean isOdd = (len % 2 != 0);
        long firstHalf = Long.parseLong(n.substring(0, mid));

        // Generate potential palindromes
        list.add(findNearestPalindrome(firstHalf, isOdd));
        list.add(findNearestPalindrome(firstHalf + 1, isOdd));
        list.add(findNearestPalindrome(firstHalf - 1, isOdd));
        list.add((long) Math.pow(10, len - 1) - 1); // 9, 99, 999, etc.
        list.add((long) Math.pow(10, len) + 1); // 101, 1001, etc.

        long num = Long.parseLong(n);
        long maxDiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;

        for (Long element : list) {
            if (num == element) continue;
            long currDiff = Math.abs(element - num);
            if (currDiff < maxDiff) {
                res = element;
                maxDiff = currDiff;
            } else if (currDiff == maxDiff) {
                res = Math.min(res, element);
            }
        }
        return String.valueOf(res);
    }

    public long findNearestPalindrome(long firstHalf, boolean isOdd) {
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(firstHalf);

        // If odd, remove the last digit before mirroring
        if (isOdd) {
            firstHalf /= 10;
        }

        // Create the second half of the palindrome
        while (firstHalf > 0) {
            palindrome.append(firstHalf % 10);
            firstHalf /= 10;
        }

        return Long.parseLong(palindrome.toString());
    }
}