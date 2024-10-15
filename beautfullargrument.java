class Solution {
    public int countArrangement(int n) {
        boolean[] isUsed=new boolean[n+1];
        return helper(1,n,isUsed);
    }
    public int helper(int pos,int n,boolean[]isUsed){
        if(pos>n){
            return 1;
        }
       int count=0;
        for(int i=1;i<=n;i++){
            if(!isUsed[i] && (i%pos ==0 || pos%i==0)){
                isUsed[i]=true;
             count+=helper(pos+1,n,isUsed);
             isUsed[i]=false;
            }
        }
        return count;
    }
}