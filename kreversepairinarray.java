class Solution {
    private static final int MOD = 1000000007;
  public int kInversePairs(int n, int k) {
      //create a dp table 
      int dp[][]=new int[n+1][k+1];

      //base case for the 0 numbers 
      dp[0][0]=1;
      //expolre for the next 
      for(int i=1;i<=n;i++){
          for(int j=0;j<=k;j++){
              //we can use the built format of previous element 
              for(int m=0;m<=j && m<i;m++){
                  dp[i][j]= (dp[i][j]+dp[i-1][j-m]) % MOD;
              } 
          }
      }
      return dp[n][k];
  }
}