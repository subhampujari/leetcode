class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n=days.length;
        int dp[]=new int[n];
          dp[0]=Math.min(cost[0],Math.min(cost[1] ,cost[2]));
        for(int i=1;i<n;i++){
            int last7=i;
            int last30=i;

            while(last7>=0 && days[last7]+7>days[i])last7--;
             while(last30>=0 && days[last30]+30>days[i])last30--;
           //if i brought 1 day ticket
             dp[i]=cost[0]+dp[i-1];

             // if i brought 7 daty ticket at that index
          if(last7!=-1)dp[i]=Math.min(dp[i],cost[1]+dp[last7]);
          else dp[i]=Math.min(dp[i],cost[1]);

          
             // if i brought 30 daty ticket at that index
          if(last30!=-1)dp[i]=Math.min(dp[i],cost[2]+dp[last30]);
          else dp[i]=Math.min(dp[i],cost[2]);
        }
        return dp[n-1];
    }
}
