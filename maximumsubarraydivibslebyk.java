class Solution {
    public long maxSubarraySum(int[] A, int k) {
       long[] prefix = new long[k];
        Arrays.fill(prefix, (long)1e15);
        prefix[k - 1] = 0;
        long res = (long)-1e15, pre = 0;
        for (int i = 0; i < A.length; i++) {
            pre += A[i];// add the current value
            res = Math.max(res, pre - prefix[i % k]);// store the maximum 
            prefix[i % k] = Math.min(prefix[i % k], pre);//store the minimum value at i % k 
        }
        return res;
    }
}
