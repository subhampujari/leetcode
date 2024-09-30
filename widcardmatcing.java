class Solution {
    public boolean isMatch(String s, String p) {
       //for solving these problem we sholud use the Dynammic programming
       int m=s.length();
       int n=p.length();
       boolean  dp[][]=new boolean[m+1][n+1];//Dp boolean array 
       dp[0][0]=true;//for the blank chrcters
       //for filling  the first row for the astric 
       for(int i=1;i<=n;i++){
        if(p.charAt(i-1)=='*'){
            dp[0][i]=dp[0][i-1];
        }
       } 
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){//chcking if the char at the p strinng is * then put the up and side  cloumn value
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else if(p.charAt(j-1)=='?'|| s.charAt(i-1)==p.charAt(j-1)){//if char is equal to p and s  or p have ? store the digonal value
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=false;//else put the false
                }
            }
        }
        return dp[m][n];
    }
}
