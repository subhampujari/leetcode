class Solution {
    public int shortestSubarray(int[] nums, int k) {
       /* int n=nums.length;
        int min=Integer.MAX_VALUE;

        //creating prefix sum array 
        long prefixSum[]=new long[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            while(!dq.isEmpty() && prefixSum[i]-prefixSum[dq.peekFirst()]>=k){
                min=Math.min(min,i-dq.pollFirst());
            }

             while(!dq.isEmpty() && prefixSum[i]<=prefixSum[dq.peekLast()]){
               dq.pollLast();
             }
             dq.offerLast(i);
        }

        return min==Integer.MAX_VALUE?-1:min;
        */
         int n = nums.length;
        
        // Initialize the sliding window and variables
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // Expand the window by adding the right element
            currentSum += nums[right];
            
            // Shrink the window as long as the sum is greater than or equal to k
            while (currentSum >= k) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        
        // If no valid subarray is found, return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
