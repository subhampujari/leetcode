class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // simply we can solve this question using the dynmic programming
        if(dungeon.length==0 || dungeon==null)return 0;//base case
       int m=dungeon.length;
       int n=dungeon[0].length;
        //Declare 2d arrray for Dp..
        int dp[][]=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=Math.max(1,1-dungeon[m-1][n-1]);//filing the bottom right corner
                }else if(i==m-1){
                    dp[m-1][j]=Math.max(dp[m-1][j+1]-dungeon[m-1][j],1);// last row filling 
                }else if(j==n-1){
                    dp[i][n-1]=Math.max(dp[i+1][n-1]-dungeon[i][n-1],1);//last column fillng
                }else{
                    dp[i][j]=Math.min(Math.max(dp[i][j+1]-dungeon[i][j],1),Math.max(dp[i+1][j]-dungeon[i][j],1));//others row and column
                }
            }
           
        }
         return dp[0][0];// i follow the bottom up approach
    }
}
