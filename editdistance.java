class Solution {
    public int minDistance(String word1, String word2) {
        //to solve this question we can use the dp 
      final  int m=word1.length();
           final int n=word2.length();

        //creating the dp matrix
        int dp[][]=new int[m+1][n+1];
        //filing the first row and first column
        for(int i=1;i<=n;++i){
            dp[0][i]=i;
        }
        for(int j=1;j<=m;++j){
            dp[j][0]=j;
        }
        //rest part of the dp array 
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1) ==word2.charAt(j-1)){//if the charctervis equal to the word 1 and word2 then put the value of digaonal 
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int digonal=dp[i-1][j-1];
                    int left=dp[i][j-1];
                    int up=dp[i-1][j];
                    dp[i][j]=Math.min(digonal,Math.min(left,up))+1;//else puth the minmum of up and left and digonal 
                }
            }
        }
        return dp[m][n];
    }
}