class Solution {
    public int minimumOperations(int[] nums) {
      // Step 1: Initialize a HashSet to track distinct elements
        HashSet<Integer> q = new HashSet<>();
        
        // Step 2: Add all elements to the HashSet to check if the array is already distinct
        for (int num : nums) {
            q.add(num);
        }
        
        // Step 3: If all elements are distinct, return 0 (no operations needed)
        if (q.size() == nums.length) {
            return 0;
        }
        
        // Step 4: Initialize operations counter and starting index
        int op = 0;
        int start = 0;
        
        // Step 5: Start removing 3 elements at a time from the beginning
        while (start < nums.length) {
            // Remove a maximum of 3 elements, or whatever is left
            int remove = Math.min(3, nums.length - start);
            start += remove;
            op++;
            
            // Clear the HashSet and add the remaining elements from `start` onwards
            q.clear();
            for (int i = start; i < nums.length; i++) {
                q.add(nums[i]);
            }
            
            // If all remaining elements are distinct, break the loop
            if (q.size() == nums.length - start) {
                break;
            }
        }
        
        // Step 6: Return the number of operations performed
        return op;
    }
}
