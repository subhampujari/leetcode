class Solution {
    public int splitArray(int[] nums, int k) {
        // we can perform the binary search on he nums
        //step 1 to find the maximumm lement and the sum of all elemnts in the array 
        int left =0;
        int right=0;
        for(int num:nums){
            left=Math.max(left,num);//finding  the maxium elemnt
            right+=num;//finding the totla sum 
        }
        //binary search 
        while(left<right){
            int mid=left+(right-left)/2;
            if(canSplit(nums,mid,k)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean canSplit(int[]nums,int mid,int k){
        int count=1;//aleast one subarray 
        int currentSum=0;
        for(int num:nums){
            if(currentSum + num >mid){
     currentSum=num;
      count++;
 if(count>k){
    return false;
   }
            }else{
                currentSum+=num;
            }
        }
        return true;
    }
}