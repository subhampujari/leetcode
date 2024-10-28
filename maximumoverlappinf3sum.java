class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
      /* //first we have to made the prefix sum ,leftmax, rightmax,of k size 
       int sum=0;
       int n=nums.length;
       int leftmax[]=new int[n];
       int rightmax[]=new int[n];
       int prefixSum[]=new int[n];

       //find out the prefix sum 
       for(int i=0;i<n;i++){
        if(i==0){
            prefixSum[i]=nums[i];
        }else{
         prefixSum[i]=prefixSum[i-1]+nums[i];
        }
       }

       //finding the leftmax of k size in the array 
       for(int i=0;i<n;i++){
        if(i<k){
            sum+=nums[i];
            leftmax[i]=sum;
        }else{
            sum+=nums[i]-nums[i-k];
            leftmax[i]=Math.max(leftmax[i-1],sum);
        }
       }
       sum=0;
       //finding the rightmax of k size in the array
       for(int i=n-1;i>=0;i--){
        if(i+k >=n){
            sum+=nums[i];
            rightmax[i]=sum;
        }else{
            sum+=nums[i]-nums[i+k];
            rightmax[i]=Math.max(rightmax[i],sum);
        }
       }
       int[] res=new int[3];
//finding the midindex 
       int maxSum = Integer.MIN_VALUE;
       int lsum=0;
       int rsum=0;
       int midIndex=-1;
       for(int i=k;i<=n-2*k;i++){
        if(leftmax[i-1]+rightmax[i+k]+(prefixSum[i+k-1]-prefixSum[i-1])>maxSum){
            maxSum=leftmax[i-1]+rightmax[i+k]+(prefixSum[i+k-1]-prefixSum[i-1]);
            lsum=leftmax[i-1];
            rsum=rightmax[i+k];
            midIndex=i;
        }
       }
       res[1]=midIndex;
       //leftmax first index of lsum 
       for(int i=k-1;i<midIndex;i++){
        if(prefixSum[i]-(i-k < 0 ?0:prefixSum[i-k])==lsum){
        res[0]=i-k+1;
       break;
        }
       }

       //rightmax index of rsum 
       for(int i=midIndex+(2*k)-1;i<n;i++){
        if(prefixSum[i]-prefixSum[i-k]==rsum){
            res[2]=i-k+1;
            break;
        }
       }
       return res;
       */
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] prefixSum = new int[n + 1]; // Use n + 1 to handle prefix sums easily

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]; // Use 1-based index for easier calculations
        }

        // Calculate leftMax indices for maximum sums of k-sized subarrays
        int maxSum = 0;
        for (int i = k - 1; i < n; i++) {
            int currentSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (currentSum > maxSum) {
                leftMax[i] = i + 1 - k; // Store the start index of the max sum
                maxSum = currentSum;
            } else {
                leftMax[i] = (i == 0) ? 0 : leftMax[i - 1]; // Carry forward the last maximum index
            }
        }

        // Calculate rightMax indices for maximum sums of k-sized subarrays
        maxSum = 0;
        for (int i = n - k; i >= 0; i--) {
            int currentSum = prefixSum[i + k] - prefixSum[i];
            if (currentSum >= maxSum) {
                rightMax[i] = i; // Store the start index of the max sum
                maxSum = currentSum;
            } else {
                rightMax[i] = (i == n - 1) ? n - 1 : rightMax[i + 1]; // Carry forward the last maximum index
            }
        }

        int[] res = new int[3];
        maxSum = 0;

        // Find the best combination of left, mid, and right indices
        for (int i = k; i <= n - 2 * k; i++) {
            int l = leftMax[i - 1]; // The best left index before mid
            int r = rightMax[i + k]; // The best right index after mid

            // Calculate total sum
            int total = (prefixSum[l + k] - prefixSum[l]) + 
                        (prefixSum[i + k] - prefixSum[i]) + 
                        (prefixSum[r + k] - prefixSum[r]);
            
            if (total > maxSum) {
                res[0] = l; // Store left index
                res[1] = i; // Store mid index
                res[2] = r; // Store right index
                maxSum = total; // Update max sum
            }
        }

        return res;
    }
}
