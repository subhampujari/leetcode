class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       //we can solve the question using the pointer
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       ListNode prev=dummy;
       ListNode curr=head;
       while(curr!=null){//if curr pinter is not null then enter in to the loop
        boolean found=false;
        while(curr.next!=null && curr.val==curr.next.val){//if curr..val and curr.next.val is equal 
            curr=curr.next;//then move the curr pointer
            found =true;//make the boolean function true
        }
        if(found){
            prev.next=curr.next;//if there is duplicates find them deleet it
        }else{
            prev=prev.next;//else move the prev pointer
        }
        curr=curr.next;
       }
       return dummy.next;
    }
}