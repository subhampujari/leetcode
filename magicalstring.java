class Solution {
    public int magicalString(int n) {
       StringBuilder magicalString = new StringBuilder("122");
        int index = 2;
        
        // Generate the magical string until its length is at least n
        while (magicalString.length() < n) {
            int repeat = magicalString.charAt(index) - '0'; // Get the repeat count
            char nextChar = (magicalString.charAt(magicalString.length() - 1) == '1') ? '2' : '1'; // Determine the next char
            
            // Append the next character 'repeat' times
            for (int i = 0; i < repeat; i++) {
                magicalString.append(nextChar);
            }
            
            index++;
        }
        
        // Count the number of '1's in the first n characters
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (magicalString.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }
}