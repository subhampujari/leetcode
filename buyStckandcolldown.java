class Solution {
    public int maxProfit(int[] prices) {
       //if the pries is null and the length is 0
       if(prices==null || prices.length==0)return 0;
       //creating thre array for stroing the hold and sell and cooldwon
       int[] hold=new int[prices.length];
       int[] sell=new int[prices.length];
       int[]cooldown=new int[prices.length];
       //putting the in zero index as zero becuse first buy is alwys no profit
       hold[0]=-prices[0];
       sell[0]=0;
       cooldown[0]=0;
       //itrating overal array and find out the maxmium profit
       for(int i=1;i<prices.length;i++){
        hold[i]=Math.max(hold[i-1],cooldown[i-1]-prices[i]);//either i will hold or buy 
        sell[i]=hold[i-1]+prices[i];//profit of selling
        cooldown[i]=Math.max(cooldown[i-1],sell[i-1]);//cooldpown profit
       } 
       return Math.max(cooldown[prices.length-1],sell[prices.length-1]);
    }
}
