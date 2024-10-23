class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*    // Create a min-heap based on the absolute distance from x
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a[0] - x);
            int diffB = Math.abs(b[0] - x);
            if (diffA == diffB) {
                return a[0] - b[0]; // If distances are equal, sort by value
            }
            return diffA - diffB; // Sort by distance
        });

        // Add all elements to the min-heap
        for (int num : arr) {
            minHeap.offer(new int[]{num});
        }

        // Extract the k closest elements
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll()[0]);
        }

        // Sort the result list before returning
        result.sort(Integer::compareTo);

        return result;*/
         List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - k;
        binarySearch(arr, k, x, left, right, result);
        return result;
    }
    private void binarySearch(int[] arr, int k, int x, int left, int right, List<Integer> result) {
        if (left == right) {
            for (int i = left; i < left + k; i++) result.add(arr[i]);
            return;
        }
        int mid = left + (right - left) / 2;
        if (x - arr[mid] > arr[mid + k] - x) binarySearch(arr, k, x, mid + 1, right, result);
        else binarySearch(arr, k, x, left, mid, result);
    }
}
