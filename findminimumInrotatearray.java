class Solution {
    public int findMin(int[] nums) {
       //to solve this question we use the binary search using 3steps..
       //declare the left and right pointer
       int left=0;
       int right=nums.length-1;
       while(left<right){
        int mid=left+(right-left)/2;
        //step 1 if we find mid is less then right then the minimum is alwys in eleft part so we move right to as mid
        if(nums[mid]<nums[right]){
            right=mid;
        }//step 2 if we find that mid is greater than right then we sure that it present in right part we move left to mid+1
        else if(nums[mid]>nums[right]){
         left=mid+1;
        }else{
            right--;//step 3 if we find the mid and right are equal then we can say in which side the minimum is present so we simply reduce the right pointer to reduce the numbeer of steps ...
        }
       
    }
    return nums[left];
}
}