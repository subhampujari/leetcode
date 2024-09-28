class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
         int totalCount = 0;
        int n = nums.length;

        // Array of HashMaps to store the counts of subsequences for each index
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        // Iterate over every pair of elements
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j]; // Calculate the difference
                int countAtJ = dp[j].getOrDefault(d, 0); // Get count of subsequences ending at j with difference d

                // Update the map for index i
                dp[i].put(d, dp[i].getOrDefault(d, 0) + countAtJ + 1);

                // Add to totalCount the number of new subsequences formed
                totalCount += countAtJ; // Adding countAtJ gives the number of valid subsequences of length at least 3
            }
        }

        return totalCount; // Return the total count of arithmetic subsequences
    }
}
