class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;

        // Step 1: Find the first decreasing element from the end
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such element is found, it means we are at the last permutation
        if (i < 0) {
            return -1; // No greater permutation possible
        }

        // Step 2: Find the smallest element larger than digits[i] to its right
        int j = length - 1;
        while (j > i && digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the found elements
        swap(digits, i, j);

        // Step 4: Reverse the sequence from i + 1 to the end
        reverse(digits, i + 1, length - 1);

        // Convert char array back to integer
        long result = Long.parseLong(new String(digits));
        
        // Check if the result fits in a 32-bit integer
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        
        return (int) result;
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    } 
    
