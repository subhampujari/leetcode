class FreqStack {
    //to keep the track of frequency 
    private Map<Integer,Integer> freq;

   private Map<Integer,Stack<Integer>> group;

   private int maxFreq;

   public FreqStack() {
       freq=new HashMap<>();
       group=new HashMap<>();
       maxFreq=0;
   }
   
   public void push(int val) {
       int f=freq.getOrDefault(val,0)+1;
       freq.put(val,f);

       //push into the group 
       group.putIfAbsent(f,new Stack<>());
       group.get(f).push(val);

       //updat ethe max frequermcy 
       maxFreq=Math.max(maxFreq,f);
   }
   
   public int pop() {
       //get thetstack at the max freq
       Stack<Integer> st=group.get(maxFreq);

       int val=st.pop();

       //remove from the freq map
       freq.put(val,freq.get(val)-1);

       if(st.isEmpty()){
           maxFreq--;
       }
       return val;
   }
}

