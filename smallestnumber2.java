class Solution {
    public int smallestRangeII(int[] A, int K) {
         int i, min=0, max=0, min1, min2, max1, max2, length = A.length, diff=0;
         Arrays.sort(A);
         diff = A[length-1]-A[0];
         int result = Integer.MAX_VALUE;
         
             min1 = A[0]+K;
             max1 = A[length-1]-K;
         
         for(i=1;i<length;i++){
             min2 = A[i]-K;
             max2 = A[i-1]+K;
             min = Math.min(min1, min2);
             max = Math.max(max1, max2);
             result = Math.min(result, max-min);
         }
         return Math.min(diff, result);
     }
 }