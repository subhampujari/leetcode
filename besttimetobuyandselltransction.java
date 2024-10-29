class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash=0;
        int hold=-prices[0];
        for(int i=1;i<prices.length;i++){
            int price=prices[i];
            cash=Math.max(cash,hold+price-fee);//sell the stock
            hold=Math.max(hold,cash-price);//buy the saock
        }
        return cash;
    }
}
