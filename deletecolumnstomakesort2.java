class Solution {
    public int minDeletionSize(String[] strs) {
     int n = strs.length, m = strs[0].length(), i, j;
     int res = 0;
     //for every col, need to check whether it will increase the deletion.
     //need to go through very column, as it's possible that prior has == thus still need compare.
     boolean[] sorted = new boolean[n];
     for (j = 0; j < m; j++) {
         for (i = 0; i < n - 1; i++) {
             if (!sorted[i] && (strs[i].charAt(j) > strs[i + 1].charAt(j))) {
                 res++;
                 //find one inordered, then need delete the whole col.
                 break;
             }
         }
         //the whole colum is sorted, need keep so later cols can refer i.e., x=x<y.
         if (i == n - 1) {
             for (int k = 0; k < n - 1; k++) {
                 //it's important to combine previous col's result, as FFT | FTF = FTT. F means == here.
                 sorted[k] |= strs[k].charAt(j) < strs[k + 1].charAt(j);
             }
         }
     }
     return res;
 }
}
