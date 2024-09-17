class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      if(nums.length==0 || nums==null)return new ArrayList<>();

         //step 1 to sort the array
         Arrays.sort(nums);
         int n=nums.length;
         //Step 2 create 2 array one for the maxSize and one for the maxIndex
         int dp[]=new int[n];
         int index[]=new int[n];

         int maxSize=0;
         int maxIndex=0;

         //fill the array of dp with 1 and index array with -1
         Arrays.fill(dp,1);
         Arrays.fill(index,-1);

         for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                //checking for the condeiton 
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        index[i]=j;
                    }
                }
            }
            if(dp[i]>maxSize){
                maxSize=dp[i];
                maxIndex=i;
            }
         }
         List<Integer> res=new ArrayList<>();
         while(maxIndex!=-1){
            res.add(nums[maxIndex]);
            maxIndex=index[maxIndex];
         }
         return res;
    }
}