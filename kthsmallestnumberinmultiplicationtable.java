class Solution {
    public int findKthNumber(int m, int n, int k) {
        //we can solve this question using the binary search
         int left = 1, right = m * n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(m, n, mid);
            
            if (count < k) {
                left = mid + 1; // Move to the right
            } else {
                right = mid; // Move to the left
            }
        }
        
        return left; // or return right, both will be equal
    }
     private static int countLessEqual(int m, int n, int x) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n); // Count how many multiples of i are <= x
        }
        return count;
    }
}