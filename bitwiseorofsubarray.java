class Solution {
    public int subarrayBitwiseORs(int[] arr) {
         // Set to store all distinct OR values
        Set<Integer> distinctOrs = new HashSet<>();
        // Set to store OR results for subarrays ending at the current element
        Set<Integer> currentOrs = new HashSet<>();
        
        // Iterate through each element of the array
        for (int num : arr) {
            // Create a new set for OR results of subarrays ending at this element
            Set<Integer> newOrs = new HashSet<>();
            
            // For each OR result in currentOrs, OR it with the current number
            for (int orValue : currentOrs) {
                newOrs.add(orValue | num);
            }
            
            // Also add the current number as a subarray on its own
            newOrs.add(num);
            
            // Add all OR results from the newOrs set to the global distinctOrs set
            distinctOrs.addAll(newOrs);
            
            // Update currentOrs to the new set for the next iteration
            currentOrs = newOrs;
        }
        
        // Return the size of the distinct ORs set, which contains all distinct OR results
        return distinctOrs.size();
    }
}
