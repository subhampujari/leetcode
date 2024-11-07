class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
         // Priority Queue for storing fractions (value, (numerator index, denominator index))
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]])
        );
        
        int n = arr.length;
        
        // Initialize the min-heap with fractions of the form arr[i] / arr[n-1]
        for (int i = 0; i < n - 1; i++) {
            minHeap.offer(new int[]{i, n - 1});
        }
        
        // Pop k times to get the k-th smallest fraction
        for (int i = 0; i < k - 1; i++) {
            int[] current = minHeap.poll();
            int numeratorIndex = current[0];
            int denominatorIndex = current[1];
            
            // If we can move the denominator to the left (smaller value), we do so
            if (denominatorIndex > numeratorIndex + 1) {
                minHeap.offer(new int[]{numeratorIndex, denominatorIndex - 1});
            }
        }
        
        // The result is the k-th smallest fraction
        int[] result = minHeap.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}
