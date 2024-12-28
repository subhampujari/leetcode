class Solution {
    public String removeDuplicates(String s) {
      /* Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
                continue;
            }else{
                st.push(ch);
            }
        }

        StringBuilder sb=new StringBuilder();
         while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
*/
        char[] array = s.toCharArray();
        int i = -1;
        for (char c : array) {
            if (i >= 0 && c == array[i]) {
                i--;
            } else {
                i++;
                array[i] = c;
            }
        }
        return String.valueOf(array, 0, i + 1);
    }
}
