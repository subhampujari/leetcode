class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //we can solve this question using the dynamic programming 
        int [][][]dp=new int[m][n][maxMove+1];

        dp[startRow][startColumn][0]=1;//intialy starting poistion 
         final int MOD = 1000000007;
       int countMoves=0;
       for(int k=0;k<maxMove;k++){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j][k]>0){
                    //fisrt step to move up 
                    if(i>0){
                        dp[i-1][j][k+1]=(dp[i-1][j][k+1]+dp[i][j][k])%MOD;
                    }else{
                        countMoves=(countMoves+dp[i][j][k])%MOD;
                    }

                    //move down 
                    if(i<m-1){
                        dp[i+1][j][k+1]=(dp[i+1][j][k+1]+dp[i][j][k])%MOD;
                    }else{
                        countMoves=(countMoves+dp[i][j][k])%MOD;
                    }
                    //move left
                    if(j>0){
                        dp[i][j-1][k+1]=(dp[i][j-1][k+1]+dp[i][j][k])%MOD;
                    }else{
                        countMoves=(countMoves+dp[i][j][k])%MOD;
                    }
                    
                    //move right
                    if(j<n-1){
                        dp[i][j+1][k+1]=(dp[i][j+1][k+1]+dp[i][j][k])%MOD;
                    }else{
                        countMoves=(countMoves+dp[i][j][k])%MOD;
                    }
                }
            }
        }
       }
return countMoves;
    }
}
