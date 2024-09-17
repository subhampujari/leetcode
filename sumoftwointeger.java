class Solution {
    public int getSum(int a, int b) {
        //using the caraot and & and << opertor we can do the answer
        while(b!=0){
            //continue till the carry comees
            int carray =a&b;
            a=a^b;
            b=carray<<1;
        }
        return a;
    }
}
