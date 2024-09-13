class Solution {
    public String removeDuplicateLetters(String s) {
        // solve using the stack ...
        if(s==null || s.length()==0)return "";

       //Step1  build nne array to store the frequency of the ech character
       int [] count=new int[26];

       for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        count[c-'a']++;
       }
        //step 2 is used to creat one stack to print the string in legographically
        Stack<Character> st=new Stack<>();
        //create one boolean array of 26 size to track the letterrs which are already being used ..
        boolean isVist[]=new boolean[26];
        for(char c:s.toCharArray()){
            count[c-'a']--;// reduse one when we are visited the char 
            //if we already visietd the char then skip that one
            if(isVist[c-'a']){
                continue;
            }
        
        //now we can orede the stack on legographically 
        while(!st.isEmpty() && st.peek() > c && count[st.peek()-'a'] > 0){
            isVist[st.pop()-'a']=false;
        }

        // after that push the char if we are not visit
        st.push(c);
        isVist[c-'a']=true;
        }
        
        // create one stringbuilder to store the char and return 
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}