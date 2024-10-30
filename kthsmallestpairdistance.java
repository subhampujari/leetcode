class Solution {
    public int smallestDistancePair(int[] nums, int k) {
       /* PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Generate all pair distances
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                minHeap.offer(Math.abs(nums[i] - nums[j]));
            }
        }

        // Extract the kth smallest distance
        int kthSmallestDistance = 0;
        for (int i = 0; i < k; i++) {
            kthSmallestDistance = minHeap.poll();
        }

        return kthSmallestDistance;
        */

        //solving it uisng the binary search 

        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];

        while(left<right){
            int mid=left+(right-left)/2;
            if(countDiff(nums,mid)<k){//count the number of oair distance till the mid point 
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;//we can sloe return right both have point to same 
    }
    public int countDiff(int[] nums,int mid){
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int j=i+1;
           while(j<n && nums[j]-nums[i]<=mid){
            j++;
           }
           count+=j-i-1;
        }
        return count;
    }
}
