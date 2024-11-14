class Solution {
    public int flipgame(int[] fronts, int[] backs) {
      // Step 1: Create a set to track forbidden numbers
        Set<Integer> forbidden = new HashSet<>();
        
        // Step 2: Populate the forbidden set with numbers that appear on both front and back of any card
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                forbidden.add(fronts[i]);
            }
        }
        
        // Step 3: Initialize the result to a large value (similar to infinity)
        int res = Integer.MAX_VALUE;
        
        // Step 4: Iterate through both fronts and backs to find the smallest valid number
        for (int i = 0; i < fronts.length; i++) {
            if (!forbidden.contains(fronts[i])) {
                res = Math.min(res, fronts[i]);
            }
            if (!forbidden.contains(backs[i])) {
                res = Math.min(res, backs[i]);
            }
        }
        
        // Step 5: Return the result if found, otherwise return 0
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
