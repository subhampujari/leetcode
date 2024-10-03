class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> st=new Stack<>();//creating a stack for valid paranthiis 
       int max=0;//giving the length of substring of valid substring
       st.push(-1);//intially put the value -1
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);//checking the chcrter
        if(ch=='('){//if the charctres is open paranthesis then blindly push into the stack
            st.push(i);
        }else{
            st.pop();//if the chcrters is close brackets then pop
            if(st.isEmpty()){//chcking if the stsck is empty then push the i
                st.push(i);
            }else{
                int length=i-st.peek();
                max=Math.max(max,length);//if stack is not empty then simple take the maximum of i and peek of the stack
                        }
        }
       }
       return max;//return thr max substring
    }
}
