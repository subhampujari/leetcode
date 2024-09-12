class Solution {
    public List<Integer> countSmaller(int[] nums) {
      int n = nums.length;
        List<Integer> counts = new ArrayList<>(Collections.nCopies(n, 0));
        Integer[] indices = new Integer[n];

        // Initialize indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Call the modified merge sort
        mergeSort(nums, indices, counts, 0, n - 1);
        return counts;
    }

    private static void mergeSort(int[] nums, Integer[] indices, List<Integer> counts, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, counts, left, mid);
        mergeSort(nums, indices, counts, mid + 1, right);
        merge(nums, indices, counts, left, mid, right);
    }

    private static void merge(int[] nums, Integer[] indices, List<Integer> counts, int left, int mid, int right) {
        Integer[] tempIndices = new Integer[right - left + 1];
        int[] tempCounts = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                tempIndices[k] = indices[i];
                tempCounts[k] = counts.get(indices[i]) + count;
                i++;
            } else {
                tempIndices[k] = indices[j];
                tempCounts[k] = counts.get(indices[j]);
                count++;
                j++;
            }
            k++;
        }

        while (i <= mid) {
            tempIndices[k] = indices[i];
            tempCounts[k] = counts.get(indices[i]) + count;
            i++;
            k++;
        }

        while (j <= right) {
            tempIndices[k] = indices[j];
            tempCounts[k] = counts.get(indices[j]);
            j++;
            k++;
        }

        for (i = 0; i < tempIndices.length; i++) {
            indices[left + i] = tempIndices[i];
            counts.set(indices[left + i], tempCounts[i]);
        }
    }
    
}