class Solution {
    public int lastRemaining(int n) {
     boolean left=true;
     int head=1;
     int rem=n;
     int step=1;
     while(rem>1){
        if(left || rem %2==1){
            head+=step;//in the odd case
        }
        step*=2;//in the even case
        rem/=2;
        left=!left;
     }        
     return head;
    }
}