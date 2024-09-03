class Solution {
    public int maxProfit(int k, int[] prices) {
        // we can solve it by dynamic programing
        int n=prices.length;
        if(n==0)return 0;//base case

        if( k > n/2){
            return multipleTranstion(prices);//if k is greter then n/2 there is multiple transtion..
        }

        int dp[][]=new int[k+1][n];
        for(int i=1;i<=k;i++){
            int maxDiff=-prices[0];
            for(int j=1;j<prices.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);//update the dp array
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);// update the maxDiff
            }
        }
        return dp[k][n-1];
    }
    public int multipleTranstion(int[] prices){
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}