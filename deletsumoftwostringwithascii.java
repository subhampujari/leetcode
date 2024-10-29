class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // we can solve this questions uing the dynmic programming 
        int m=s1.length();
        int n=s2.length();

        //creating a dp table 
        int[][] dp=new int[m+1][n+1];

        //fill the first row and first col
       for(int i=1;i<=m;i++){
        dp[i][0]=dp[i-1][0]+s1.charAt(i-1);
       }
        for(int j=1;j<=n;j++){
        dp[0][j]=dp[0][j-1]+s2.charAt(j-1);
       }

       //fill the rest part of dp 
       for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1];//character are matched
            }else{
                dp[i][j]=Math.min(dp[i-1][j]+s1.charAt(i-1),dp[i][j-1]+s2.charAt(j-1));
            }
        }
       }
       return dp[m][n];
    }
}
