class Solution { 
    private Map<String, Double> memo = new HashMap<>();  
    public double soupServings(int n) {
        if (n > 5000) return 1.0; // For large n, the probability approaches 1.  
        return helper(n, n);
    }
     private double helper(int a, int b) {  
        // Create a unique key for the current state (a, b)  
        String key = a + "," + b;  
        if (memo.containsKey(key)) {  
            return memo.get(key);  
        }  

        // If one of the soups is empty  
        if (a <= 0 && b <= 0) return 0.5; // Both empty at the same time  
        if (a <= 0) return 1.0; // Soup A is empty first  
        if (b <= 0) return 0.0; // Soup B is empty first  

        // Calculate the probabilities for each operation  
        double prob = 0.25 * (helper(a - 100, b) +  
                              helper(a - 75, b - 25) +  
                              helper(a - 50, b - 50) +  
                              helper(a - 25, b - 75));  

        // Store the result in the memoization map  
        memo.put(key, prob);  
        return prob;  
    }  
}  

