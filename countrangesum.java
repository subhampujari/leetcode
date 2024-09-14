class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        //we can solve this question using the merge sort with the prefix sum ..
        int n=nums.length;
        long []prefixSum=new long[n+1];
//prefix sum of the array 
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
return countNumberOfSum(prefixSum,0,n,lower,upper);
    }
    public int countNumberOfSum(long[] prefixSum,int start,int end,int lower,int upper){
        if(start>=end){
            return 0;
        }
        int mid=start+(end-start)/2;
        int count=countNumberOfSum(prefixSum,start,mid,lower,upper)+countNumberOfSum(prefixSum,mid+1,end,lower,upper);

        // for exploring the next count
        int j=mid+1;//for the lower
        int k=mid+1;//for the upper

        for(int i=start;i<=mid;i++){
            while(j<=end && prefixSum[j]-prefixSum[i] < lower)j++;
            //for the upper case
            while(k<=end && prefixSum[k]-prefixSum[i] <= upper)k++;
            count+=k-j;
        }

        //merger the two halves
         merge(prefixSum,start,mid,end);

        return count;
    }
    private void merge(long[] prefixSums, int start, int mid, int end) {
        long[] sorted = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        
        // Merge the two halves
        while (i <= mid && j <= end) {
            if (prefixSums[i] <= prefixSums[j]) {
                sorted[k++] = prefixSums[i++];
            } else {
                sorted[k++] = prefixSums[j++];
            }
        }
        
        // Copy remaining elements
        while (i <= mid) {
            sorted[k++] = prefixSums[i++];
        }
        while (j <= end) {
            sorted[k++] = prefixSums[j++];
        }
        
        // Copy the sorted array back to prefixSums
        for (int l = 0; l < sorted.length; l++) {
            prefixSums[start + l] = sorted[l];
        }
    }
}