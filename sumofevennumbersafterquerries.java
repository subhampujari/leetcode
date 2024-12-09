class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int ans[]=new int[m];
        int i=0;
        for(int[] query:queries){
            int val=query[0];
            int index=query[1];
            int valueIndex=nums[index];
            int exactSum=valueIndex+val;
            nums[index]=exactSum;
            int totalSum=0;
            for(int curr=0;curr<n;curr++){
                if(nums[curr]%2==0){
                    totalSum+=nums[curr];
                }
            }
            ans[i]=totalSum;
            i++;
        }
        return ans;
    }
}
