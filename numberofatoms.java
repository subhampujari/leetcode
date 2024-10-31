class Solution {
    public String countOfAtoms(String formula) {
           Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentCount = new HashMap<>();
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char ch = formula.charAt(i);
            
            if (Character.isUpperCase(ch)) {
                // Start of a new element
                StringBuilder element = new StringBuilder();
                element.append(ch);
                i++;
                
                // Check for lowercase letters
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i));
                    i++;
                }
                
                // Get the full element name
                String elem = element.toString();
                
                // Get the count of the element
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) count = 1; // Default count is 1 if not specified

                // Update the current count map
                currentCount.put(elem, currentCount.getOrDefault(elem, 0) + count);
                
            } else if (ch == '(') {
                // Push current map onto stack
                stack.push(currentCount);
                currentCount = new HashMap<>();
                i++;
                
            } else if (ch == ')') {
                // Closing a parenthesis
                i++;
                
                // Get the multiplier for the group
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) count = 1; // Default multiplier is 1 if not specified

                // Pop from stack and combine counts
                Map<String, Integer> previousCount = stack.pop();
                for (Map.Entry<String, Integer> entry : currentCount.entrySet()) {
                    previousCount.put(entry.getKey(), previousCount.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
                currentCount = previousCount;
            }
        }

        // Prepare the result in sorted order
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : currentCount.entrySet()) {
            result.add(entry.getKey() + (entry.getValue() > 1 ? String.valueOf(entry.getValue()) : ""));
        }
        Collections.sort(result);

        return String.join("", result);
        /*int n = formula.length();
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<String,Integer>());
        int index=0;
        // O(N) + O(K)
        //O(N)*(N)
        while(index<n){
            char ch = formula.charAt(index);
            if(ch == '('){
                stack.push(new HashMap<String,Integer>());
                index++;
            }else if(ch == ')'){
                HashMap<String,Integer> curMap = stack.pop();
                index++; //move to the next char
                //find the multiplier
                StringBuilder multiplier = new StringBuilder();
                while(index < n && Character.isDigit(formula.charAt(index))){
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                //multiply the count - ()n
                if(multiplier.length()>0){
                    int m = Integer.parseInt(multiplier.toString());
                    for(String atom : curMap.keySet()){
                        curMap.put(atom, curMap.get(atom) * m);
                    }
                }
                //insert popped map elements into stack top
                for(String atom : curMap.keySet()){
                    stack.peek().put(
                        atom,
                        stack.peek().getOrDefault(atom,0)+curMap.get(atom)
                    );
                }

            }else{ //Atom name and count
                // take the uppercase letter 
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                //collect all lowercase letters
                while(index < n && Character.isLowerCase(formula.charAt(index))){
                    atomName.append(formula.charAt(index));
                    index++;
                }
                StringBuilder count = new StringBuilder();
                while(index < n && Character.isDigit(formula.charAt(index))){
                    count.append(formula.charAt(index));
                    index++;
                }
                int c = (count.length()>0)?Integer.parseInt(count.toString()):1;
                stack.peek().put(
                        atomName.toString(),
                        stack.peek().getOrDefault(atomName.toString(),0)+c
                    );
            }
        }
        // 2K
        TreeMap<String,Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder res = new StringBuilder();
        for(String atom : sortedMap.keySet()){
            res.append(atom);
            int count = sortedMap.get(atom); 
            if(count>1){
                res.append(count);
            }
        }
        return res.toString();*/
    }
}