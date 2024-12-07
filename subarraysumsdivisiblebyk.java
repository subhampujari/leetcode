class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle the case where a subarray directly divides by k
        int currSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currSum += num;
            int mod = ((currSum % k) + k) % k; // Normalize negative modulus
            
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        return count;
    }
}
