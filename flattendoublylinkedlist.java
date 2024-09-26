class Solution {
    public Node flatten(Node head) {
       // we can solve this pointer with the DFS approch 
       Node temp=head;//referance of head 
       while(temp!=null){
        Node t=temp.next;//storing the next pointer of the temp or next pointer of the first child
        if(temp.child!=null){
            Node c=flatten(temp.child);//tfindng the child node
            temp.next=c;//connect the temp pointer to the child
            c.prev=temp;//prev of c is temp
            while(c.next!=null){
                c=c.next;//going to the last node where the next child 
            }
            c.next=t;//conect to the next 
            if(t!=null)t.prev=c;
        }
        temp.child=null;//set the child of temp is null
        temp=t;
       }
       return head;
    }
}
