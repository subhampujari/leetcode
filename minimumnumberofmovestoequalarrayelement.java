class Solution {
    public int minMoves2(int[] nums) {
     //sort the array 
     Arrays.sort(nums); // Step 1: Sort the array to find the median
     int n=nums.length;
     int median=nums[n/2];

int moves=0;
     for(int num:nums){// Step 2: Calculate the total moves needed to make all elements equal to the median
moves+=Math.abs(num-median);
     }   
     return moves;
    }
}
