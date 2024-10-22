
import java .io.*;
class Solution {
    private List<Integer> price;
    private List<List<Integer>> special;
    private List<Integer> needs;
    private Map<String, Integer> memo;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
       this.price = price;
        this.needs = needs;
        this.special = special;
        this.memo = new HashMap<>();
        return dfs(needs);
    }
   
    private int dfs(List<Integer> needs) {
        String key = getKey(needs);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Calculate the cost without using any special offer
        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // Try each special offer
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>(needs);
            boolean canUseOffer = true;

            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < offer.get(i)) {
                    canUseOffer = false;
                    break;
                }
                newNeeds.set(i, needs.get(i) - offer.get(i));
            }

            if (canUseOffer) {
                int costWithOffer = offer.get(needs.size()) + dfs(newNeeds);
                minCost = Math.min(minCost, costWithOffer);
            }
        }

        memo.put(key, minCost);
        return minCost;
    }
    private String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int need : needs) {
            sb.append(need).append(",");
        }
        return sb.toString();
    }
}