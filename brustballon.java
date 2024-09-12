class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int newNums[]=new int[n+2];//creating new Array padding the first and las t index qwith  1 and size is  
        //+2 of the orginal Array
        newNums[0]=1;
        newNums[n+1]=1;
      for(int i=1;i<=n;i++){
            newNums[i]=nums[i-1];
       }
        int[][] dp=new int[n+2][n+2];
       // updating the values of dpsuing three for lops
        for(int len=1;len<=n;len++){
           for(int left=1;left<=n-len+1;left++){
                int right=len+left-1;
                for(int i=left;i<=right;i++){
                   dp[left][right]=Math.max(dp[left][right],newNums[left-1]*newNums[i]*newNums[right+1]+dp[left][i-1]+dp[i+1][right]);
               }
         }
     }
    return dp[1][n];

       /* int n=nums.length+2;
        int[]newNum=new int[n];
        newNum[0]=1;
        newNum[n-1]=1;
        for(int i=0;i<nums.length;i++)
            newNum[i+1]=nums[i];
        return getcoins(newNum,0,n-1);
    }
    Map<String,Integer> map=new HashMap<>();
    public int getcoins(int[] a,int l,int r){
        String key=l+"|"+r;
        int maxcoins=0;
        if(!map.containsKey(key)){       
        for(int i=l+1;i<r;i++){
            int score=a[l]*a[i]*a[r];
            maxcoins=Math.max(maxcoins,score+getcoins(a,l,i)+getcoins(a,i,r));
        }
        map.put(key,maxcoins);
        }
        return map.get(key);
        */
    }
}