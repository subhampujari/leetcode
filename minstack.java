class MinStack {
    //ww can solve this question by using one stack or 2 stack 
    private Stack<Pair> st;
    class Pair{
     int val;//for vale;
     int min;//for getting minimum value
 public Pair(int val,int min){
     this.val=val;
     this.min=min;
 }
    }
     public MinStack() {
         st=new Stack<>();
     }
     
     public void push(int val) {
         //for pus we have to calulate the minvalue of stack peek and the push value 
         int min=st.isEmpty()?val:Math.min(val,st.peek().min);
         st.push(new Pair(val,min));
     }
     
     public void pop() {
          if (st.isEmpty()) throw new IllegalStateException("Stack is empty");
         //sipmly we can pop that from stack 
         if(!st.isEmpty()){
             st.pop();
         }
     }
     
     public int top() {
          if (st.isEmpty()) throw new IllegalStateException("Stack is empty");
         return  st.peek().val;
     }
     
     public int getMin() {
          if (st.isEmpty()) throw new IllegalStateException("Stack is empty");
          return st.peek().min;
     }
 }