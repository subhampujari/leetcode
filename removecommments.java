class Solution {
    public List<String> removeComments(String[] source) {
         List<String> result = new ArrayList<>();
        boolean inBlockComment = false;
        StringBuilder currentLine = new StringBuilder();

        for (String line : source) {
            int i = 0;
            while (i < line.length()) {
                if (inBlockComment) {
                    // Check for end of block comment
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlockComment = false; // End block comment
                        i += 2; // Move past "*/"
                    } else {
                        i++; // Skip this character
                    }
                } else {
                    // Check for start of comments
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break; // End of the line (line comment)
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlockComment = true; // Start block comment
                        i += 2; // Move past "/*"
                    } else {
                        currentLine.append(line.charAt(i)); // Add character to current line
                        i++;
                    }
                }
            }

            // If not in a block comment and currentLine has content, add it to result
            if (!inBlockComment && currentLine.length() > 0) {
                result.add(currentLine.toString());
                currentLine.setLength(0); // Reset current line
            }
        }

        return result;
    }
}