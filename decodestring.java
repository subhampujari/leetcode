class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);
            
            if (Character.isDigit(ch)) {
                // If it's a digit, we need to calculate the full number
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count); // Push the repeat count onto the stack
            } else if (ch == '[') {
                // Push the current string to the stack and reset it
                resultStack.push(currentString);
                currentString = new StringBuilder(); // Reset for new substring
                index++;
            } else if (ch == ']') {
                // Pop the count and the last string from the stack
                StringBuilder previousString = resultStack.pop();
                int repeatCount = counts.pop();
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString); // Append current string 'k' times
                }
                currentString = previousString; // Move back to previous string context
                index++;
            } else {
                // Regular character, just add it to the current string
                currentString.append(ch);
                index++;
            }
        }

        return currentString.toString(); // Return the fully decoded string
    }
}
