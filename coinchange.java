class Solution {
    public int coinChange(int[] coins, int amount) {
        // to solve this question we can use the dynmaic approach 
        if(amount < 1)return 0;

        //dp array
        int dp[]=new int[amount+1];

        for(int i=1;i<=amount;i++){
        dp[i]=Integer.MAX_VALUE;
            //try for the whole coint
            for(int coin:coins)
                if(coin <=i && dp[i-coin]!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
        }
        if(dp[amount]==Integer.MAX_VALUE)return -1;
            return dp[amount];
    }
}
