class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            values.add(curr.val);
            curr=curr.next;
        }
        int[]ans=new int[values.size()];
        Stack<Integer> nextGreater=new Stack<>();
        for(int i=values.size()-1;i>=0;i--){
              while(!nextGreater.isEmpty()&& values.get(nextGreater.peek())<=values.get(i)){
                nextGreater.pop();
              }
              if(!nextGreater.isEmpty()){
                ans[i]=values.get(nextGreater.peek());
              }else{
                ans[i]=0;
              }
              nextGreater.push(i);
        }
        return ans;
    }
}