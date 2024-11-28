class Solution {
    public int maxSubarraySumCircular(int[] arr) {
         // Your code here
        int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's Algorithm
        int maxKadane = kadane(arr);
        
        // Step 2: Find the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Step 3: Find the minimum subarray sum using modified Kadane's Algorithm
        int minKadane = minKadane(arr);
        
        // Step 4: If the total sum is equal to the minimum subarray sum, it means all elements are negative
        if (totalSum == minKadane) {
            return maxKadane;
        }
        
        // Step 5: Return the maximum of the max subarray sum found by Kadane's algorithm and the circular subarray sum
        return Math.max(maxKadane, totalSum - minKadane);
    }
     // Function to implement Kadane's Algorithm
    public static int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    // Function to find the minimum subarray sum using Kadane's Algorithm
    public static int minKadane(int[] arr) {
        int minSum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            minSum = Math.min(minSum, currentSum);
        }
        
        return minSum;
    }

