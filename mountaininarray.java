class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxlen = 0;
        int i = 1;
        
        while (i < n - 1) {
            // Check if `i` is a peak 🌄
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Move left to the start of the mountain
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Move right to the end of the mountain
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate mountain length and update max length if needed
                maxlen = Math.max(maxlen, right - left + 1);

                // Move `i` to the end of the mountain
                i = right;
            } else {
                i++;
            }
        }
        return maxlen;
    }
}
