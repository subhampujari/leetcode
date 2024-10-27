class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //we can solve it using the backtracking 
        int totalSum=0;
        for(int sum:nums){
            totalSum+=sum;
        }

        //if total sum is not divisible by k then return false;
        if(k==0 || totalSum % k!=0){
            return false;
        }

        int target=totalSum/k;

    //sort the array 
    Arrays.sort(nums);

    //if the number is exist wich is greater than target then return false
    if(nums[nums.length-1]>target){
        return false;
    }
    int []subSet=new int[k];
    return backtrack(nums,subSet,target,nums.length-1);
    }
    public boolean backtrack(int[] nums,int []subSet,int target,int index){
        //if we cover all the elemnt in the array 
        if(index<0){
            for(int sum:subSet){
                if(sum!=target){
                    return false;
                }
            }
            return true;
        }

        //eplore all the next case 
         int num = nums[index];
        // Try to put the current number in each subset
        for (int i = 0; i < subSet.length; i++) {
            if (subSet[i] + num <= target) {
               subSet[i] += num; // Choose the number for this subset
                if (backtrack(nums, subSet, target, index - 1)) {
                    return true;
                }
                subSet[i] -= num; // Backtrack
            }
            // If this subset is empty, no need to try further
            if (subSet[i] == 0) {
                break;
            }
        }
        return false;
    }
}
