
class Solution {
    public int maxChunksToSorted(int[] arr) {
         int n=arr.length;
            int pre[]=new int[n];
           int suf[]=new int[n];
          pre[0]=arr[0];
      for(int i=1;i<n;i++)
       {
             pre[i]=Math.max(arr[i],pre[i-1]);
          }
           suf[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
       {
      suf[i]=Math.min(suf[i+1],arr[i]);
          }
       int count=0;
     for(int i=0;i<n-1;i++)
         {
       if(pre[i]<=suf[i+1])
      count++;
      }
     return count+1;
    }
}