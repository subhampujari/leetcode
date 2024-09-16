class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        //if the target is greater thena the sun of two jug then we return the as false
        if(target > x+ y)return false;
        return target % gcd(x,y)==0;
    }
    public int gcd(int x,int y){
        while(y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
}