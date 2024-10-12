class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder base7 = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);

        while (num > 0) {
            base7.append(num % 7);
            num /= 7;
        }

        if (isNegative) {
            base7.append('-');
        }

        // The digits are in reverse order, so we need to reverse the string
        return base7.reverse().toString();
    }
}
