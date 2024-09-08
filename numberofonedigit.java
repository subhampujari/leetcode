class Solution {
    public int countDigitOne(int n) {
   int ans=0;
   for(int i=1;i<=n;i*=10){
    int mul=i*10;
    int div=n/mul;
    int rem=n%mul;
    ans+=div*i;                              
    if(rem>=i){
        ans+=Math.min(rem-i+1,i);
    }
   }
   return ans;
    }
}