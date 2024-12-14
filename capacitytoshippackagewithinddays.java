class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = findMax(weights); // The smallest possible capacity is the largest single weight.
        int high = findSum(weights); // The largest possible capacity is the total weight.

        while (low <= high) {
            int mid = (low + high) / 2; // This is the candidate capacity.
            int requiredDays = findDays(weights, mid); // Find how many days are needed with `mid` capacity.
            
            // If we can ship within the given `days`, try a smaller capacity.
            if (requiredDays <= days) {
                high = mid - 1;
            } else {
                // If it takes more than `days`, we need a larger capacity.
                low = mid + 1;
            }
        }
        return low; // The lowest capacity that works is our answer.
    }

    // Helper function to find the maximum weight (single largest weight).
    public int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // Helper function to find the total sum of the weights.
    public int findSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    // Function to determine how many days it will take to ship all weights given a capacity.
    public int findDays(int[] weights, int capacity) {
        int day = 1; // Start with day 1.
        int load = 0; // Current load in the ship.

        for (int i = 0; i < weights.length; i++) {
            // If adding the current weight exceeds capacity, we need a new day.
            if (load + weights[i] > capacity) {
                day++;
                load = weights[i]; // Start a new day with the current weight.
            } else {
                load += weights[i]; // Otherwise, just add the weight to the current day's load.
            }
        }
        return day;
    }
}
