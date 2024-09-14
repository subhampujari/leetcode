class Solution {
    public ListNode oddEvenList(ListNode head) {
     /* ListNode temp=head;
      ListNode odd=new ListNode(100);
      ListNode even=new ListNode(199);
      ListNode t1=odd;
      ListNode t2=even;
      while(temp!=null){
      if(temp.val%2!=0){
        ListNode a=new ListNode(temp.val);
        t1.next=a;
        t1=a;
        temp=temp.next;
      }
      else{
        ListNode a=new ListNode(temp.val);
        t2.next=a;
        t2=a;
        temp=temp.next;
      }
      
      t1.next=even.next;
    
      }

      return odd.next;
      */
      if(head==null || head.next==null){
        return head;// if the list is empty or the one node then return the head
      }
      ListNode odd=head;// head of the odd list
      ListNode even=head.next;//head of the even list
      ListNode evenHead=even;// keep the head of even linked list omn even 

      while(even!=null && even.next!=null){
        odd.next=even.next;//link the next odd node
        odd=odd.next;//move the odd pointer to odd place
        even.next=odd.next;//link the next even pointer
        even=even.next;// move the next even node
      }
     odd.next=evenHead;// link the odd link in to the even head link
     return head;
    }
}