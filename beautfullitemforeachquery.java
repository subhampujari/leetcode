class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items based on price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        // Create a prefix array for the maximum beauty
        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        
        // Prepare result array for queries
        int m = queries.length;
        int[] result = new int[m];
        
        // For each query, we will perform binary search to find the maximum beauty
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            
            // Binary search to find the highest price <= query
            int left = 0, right = n - 1;
            int bestBeauty = 0;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    bestBeauty = maxBeauty[mid]; // If price <= query, update bestBeauty
                    left = mid + 1; // Try to find a higher price
                } else {
                    right = mid - 1; // Try lower prices
                }
            }
            
            result[i] = bestBeauty;
        }
        
        return result;
    }
}
