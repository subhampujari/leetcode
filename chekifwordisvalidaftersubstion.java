class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            st.push(c);

            if(st.size()>=3 && st.peek()=='c' && st.get(st.size()-2)=='b' && st.get(st.size()-3)=='a'){
                st.pop();//for c
                st.pop();//for b
                st.pop();// for a
            }
        }
        return st.isEmpty();
    }
}
