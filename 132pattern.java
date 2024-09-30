class Solution {
    public boolean find132pattern(int[] nums) {
        //we can solve this question by using the stack based approach 
    int n=nums.length;
        if(nums.length<3){
            return false;
        }
 
       Stack<Integer> st=new Stack<>();
       int thirdElement=Integer.MIN_VALUE;

       //itrate throghu the whole array and find out the resultt
       for(int i=n-1;i>=0;i--){
        //chking if the nums[i] is less then the third elemnt then we found the 132 patter 
        if(nums[i]<thirdElement){
            return true;
        }

        //update the third element 
        while(!st.isEmpty() && nums[i] > st.peek()){
            thirdElement=st.pop();
        }

        st.push(nums[i]);
       }

return false;
    }
}