class Solution {
    public int minAddToMakeValid(String s) {
       Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Push opening parenthesis onto the stack
                stack.push('(');
            } else {
                // If stack is not empty and the top is an opening parenthesis, pop it
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();  // Match this closing parenthesis with the opening one
                } else {
                    // If no matching opening parenthesis, push this closing parenthesis to the stack
                    stack.push(')');
                }
            }
        }
        
        // The stack will contain unmatched '(' and ')'. The size is the number of insertions needed.
        return stack.size();
    }
}
