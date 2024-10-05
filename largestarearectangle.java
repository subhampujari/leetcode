class Solution {
    public int largestRectangleArea(int[] heights) {
      int[] nse=nextSmaller(heights);
      int[] pse=prebviouSmaller(heights);
      int n=heights.length;
      int max=-1;
      for(int i=0;i<n;i++){
        int h=heights[i];//heights of the array
        int w=nse[i]-pse[i]-1;//wedth of the rectangle
        max=Math.max(max,(h*w));
      }
      return max;//max area
    }
   public int[] nextSmaller(int[] heights){
    int[] res=new int[heights.length];
    Stack<Integer> st=new Stack<>();
    int n=heights.length;
    for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();//if the stack is not empty and the elemnt of peek of height is greater than heights of ithen pop
        }
        if(st.isEmpty()){
           res[i]=n;//if the stack is empty then res[i]=n
        }else{
            res[i]=st.peek();//else stack is not empty then add stack peek
        }
        st.push(i);//push into the stack
    }
    return res;
   }
   public int[] prebviouSmaller(int[] heights){
    int[] res=new int[heights.length];
    Stack<Integer> st=new Stack<>();
    int n=heights.length;
    for(int i=0;i<n;i++){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();//if the stack is not empty and the elemnt of peek of height is greater than heights of ithen pop
        }
        if(st.isEmpty()){
           res[i]=-1;//if the stack is empty then res[i]=n
        }else{
            res[i]=st.peek();//else stack is not empty then add stack peek
        }
        st.push(i);//push into the stack
    }
    return res;
   }
}