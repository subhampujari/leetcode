class Solution {
    // Function to get the maximum number of length 'k' from an array using a stack
   private int[] maxNumberFromArray(int[] nums, int k) {
       Stack<Integer> stack = new Stack<>();
       int drop = nums.length - k;

       for (int num : nums) {
           while (drop > 0 && !stack.isEmpty() && stack.peek() < num) {
               stack.pop();
               drop--;
           }
           stack.push(num);
       }

       // Build the result from the stack
       int[] result = new int[k];
       for (int i = 0; i < k; i++) {
           result[i] = stack.get(i);
       }
       return result;
   }

   // Function to merge two arrays into the maximum possible number
   private int[] merge(int[] nums1, int[] nums2) {
       int[] result = new int[nums1.length + nums2.length];
       int i = 0, j = 0, k = 0;

       while (i < nums1.length || j < nums2.length) {
           if (compare(nums1, i, nums2, j) > 0) {
               result[k++] = nums1[i++];
           } else {
               result[k++] = nums2[j++];
           }
       }

       return result;
   }

   // Helper function to compare two subarrays
   private int compare(int[] nums1, int i, int[] nums2, int j) {
       while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
           i++;
           j++;
       }
       if (j == nums2.length) return 1;
       if (i == nums1.length) return -1;
       return Integer.compare(nums1[i], nums2[j]);
   }

   // Main function to create the maximum number of length 'k'
   public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       int[] maxNumber = new int[k];

       for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
           int[] part1 = maxNumberFromArray(nums1, i);
           int[] part2 = maxNumberFromArray(nums2, k - i);
           int[] candidate = merge(part1, part2);

           if (compare(candidate, 0, maxNumber, 0) > 0) {
               maxNumber = candidate;
           }
       }

       return maxNumber;
   }
}
