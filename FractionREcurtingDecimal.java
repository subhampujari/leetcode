class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        // Handle the sign
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        // Convert to positive values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        sb.append(num / den);

        // If there's no remainder, return the result
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        // Use a map to store previously seen remainders and their positions
        Map<Long, Integer> remainderMap = new HashMap<>();
        remainderMap.put(remainder, sb.length());

        // Compute the decimal part
        while (remainder != 0) {
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;

            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                String result = sb.substring(0, index) + "(" + sb.substring(index) + ")";
                return result;
            }

            remainderMap.put(remainder, sb.length());
        }

        return sb.toString();
    }
}
