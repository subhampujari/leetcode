class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char c:num.toCharArray()){
            while(k>0 && !st.isEmpty() && st.peek()>c){
                st.pop();
                k--;//if the current dgit is gretaer then the stack peek then pop until the stack size is not empty with k ==0
            }
            st.push(c);
        }
        //if k is greater the 0 then pop from thr stack
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());//adding into the stringbuilder
        }

        res.reverse();//reverse the strinbuilder due to use the stack FIFO 

        // Remove leading zeros
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        
        // If the result is empty, return "0"
        return res.length() == 0 ? "0" : res.toString();
    }
}
