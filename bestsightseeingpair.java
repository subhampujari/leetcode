class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int prevMax = values[0]; // prevMax will hold values[i] + i
        
        // Loop through the array starting from the second element.
        for (int j = 1; j < n; j++) {
            // Calculate score for pair (i, j) where i < j
            maxScore = Math.max(maxScore, prevMax + values[j] - j);
            
            // Update prevMax for the next iteration
            prevMax = Math.max(prevMax, values[j] + j);
        }
        
        return maxScore;
    }
}