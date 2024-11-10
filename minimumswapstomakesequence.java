class Solution {
    /*// Function to solve the problem using recursion and memoization  
     private int solve(int[] nums1, int[] nums2, int index, boolean swapped, Integer[][] dp) {  
         // Base case: If we reach the end of the arrays  
         if (index == nums1.length) {  
             return 0;  
         }  
 
         // Check memoization table  
         if (dp[index][swapped ? 1 : 0] != null) {  
             return dp[index][swapped ? 1 : 0];  
         }  
 
         int ans = Integer.MAX_VALUE; // Initialize answer as infinity  
 
         int prev1 = nums1[index - 1];  
         int prev2 = nums2[index - 1];  
         if (swapped) {  
             // If we have swapped, switch previous values  
             int temp = prev1;  
             prev1 = prev2;  
             prev2 = temp;  
         }  
 
         // Case 1: Do not swap current index  
         if (nums1[index] > prev1 && nums2[index] > prev2) {  
             ans = solve(nums1, nums2, index + 1, false, dp);  
         }  
 
         // Case 2: Swap current index  
         if (nums1[index] > prev2 && nums2[index] > prev1) {  
             ans = Math.min(ans, 1 + solve(nums1, nums2, index + 1, true, dp));  
         }  
 
         // Store the result in the memoization table  
         return dp[index][swapped ? 1 : 0] = ans;  
     }  
 
     public int minSwap(int[] nums1, int[] nums2) {  
         // Add a dummy element at the beginning  
         int[] newNums1 = new int[nums1.length + 1];  
         int[] newNums2 = new int[nums2.length + 1];  
 
         newNums1[0] = -1; // Out of bounds value  
         newNums2[0] = -1; // Out of bounds value  
 
         for (int i = 0; i < nums1.length; i++) {  
             newNums1[i + 1] = nums1[i];  
             newNums2[i + 1] = nums2[i];  
         }  
 
         Integer[][] dp = new Integer[newNums1.length][2]; // Memoization table  
         return solve(newNums1, newNums2, 1, false, dp); */
          public int minSwap(int[] A, int[] B) {
         int swapRecord = 1, fixRecord = 0;
         for (int i = 1; i < A.length; i++) {
             if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                 swapRecord++;
             } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                 int temp = swapRecord;
                 swapRecord = fixRecord + 1;
                 fixRecord = temp;
             } else {
                 int min = Math.min(swapRecord, fixRecord);
                 swapRecord = min + 1;
                 fixRecord = min;
             }
         }
         return Math.min(swapRecord, fixRecord);
     } 
     
 }
