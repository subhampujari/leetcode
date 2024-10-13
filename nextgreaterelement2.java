class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        int n=nums.length;
        int extend[]=new int[2*n];

        //fill the array with -1  of resukt array 
        Arrays.fill(result,-1);
        for(int i=0;i<n;i++){
            extend[i]=nums[i];
            extend[i+n]=nums[i];
        }

        Stack<Integer> st=new Stack<>();
        //find the next greater elemnet in the array 
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && extend[i] > extend[st.peek()]){
                 int index = st.pop();
                if (index < n) { // Only store results for the original array indices
                    result[index] = extend[i];
                }
            }
            // Push the current index onto the stack
            if (i < n) {
                st.push(i);
            }
            }
        return result;
    }
}
