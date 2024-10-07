class Solution {
    public ListNode partition(ListNode head, int x) {
        //we cann use the two pointer approch to solve the quesion
        ListNode small=new ListNode(0);//for small node or less than x
        ListNode high=new ListNode(0);
        ListNode smallTemp=small;//temparial varaible for trvesring
        ListNode highTemp=high;
        while(head!=null){//forming the new listNode for the less than x 
              if(head.val<x){
                smallTemp.next=head;//connect th small node then x 
                smallTemp=smallTemp.next;
              }else{
                highTemp.next=head;//connects the greater node to the high node
                highTemp=highTemp.next;
              }
              head=head.next;
        } 
        smallTemp.next=high.next;
        highTemp.next=null;
        return small.next;
    }
}
