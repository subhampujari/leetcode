import java.math.BigInteger;
class Solution {
    PriorityQueue<Integer> maxHeap; // max heap is small list so that root is largest
    PriorityQueue<Integer> minHeap; // min heap is large list so that the root is smallest
    Map<Integer, Integer> removedElements;
    public double[] medianSlidingWindow(int[] nums, int k) {
      /* if (nums == null || nums.length == 0 || k == 0) {
            return new double[0];
        }

        double[] medians = new double[nums.length - k + 1];

        // Initialize the first window
        long[] window = new long[k];
        for (int j = 0; j < k; j++) {
            window[j] = nums[j];
        }
        Arrays.sort(window); // Sort the initial window

        for (int i = 0; i <= nums.length - k; i++) {
            if (i > 0) {
                // Remove the outgoing element
                long outgoing = nums[i - 1];
                long incoming = nums[i + k - 1];

                // Find and remove the outgoing element
                int index = Arrays.binarySearch(window, outgoing);
                if (index >= 0) {
                    for (int j = index; j < k - 1; j++) {
                        window[j] = window[j + 1];
                    }
                    k--; // Decrease k as we've removed one element
                }

                // Insert the incoming element while keeping the array sorted
                int pos = Arrays.binarySearch(window, 0, k, incoming);
                if (pos < 0) {
                    pos = -(pos + 1); // Get the insertion point
                }

                // Shift elements to the right
                for (int j = k; j > pos; j--) {
                    window[j] = window[j - 1];
                }
                window[pos] = incoming;
                k++; // Increase k as we've added one element
            }

            // Calculate the median
            if (k % 2 == 0) {
                medians[i] = (window[k / 2 - 1] + window[k / 2]) / 2.0; // Even size
            } else {
                medians[i] = window[k / 2]; // Odd size
            }
        }

        return medians;
        */  maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
        removedElements = new HashMap<>();

        double[] medians = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        medians[0] = findMedian(k);

        int start, end;
        for (int i = 1; i < nums.length - k + 1; i++) {
            start = i;
            end = i + k - 1;
            int outgoingNum = nums[start - 1], incomingNum = nums[end];

            removedElements.put(outgoingNum, removedElements.getOrDefault(outgoingNum, 0) + 1);
            int balance = outgoingNum <= maxHeap.peek() ? -1 : 1;

            if (!maxHeap.isEmpty() && incomingNum <= maxHeap.peek()) {
                maxHeap.add(incomingNum);
                balance++;
            } else {
                minHeap.add(incomingNum);
                balance--;
            }

            if (balance < 0) {
                maxHeap.add(minHeap.poll());
            } else if (balance > 0) {
                minHeap.add(maxHeap.poll());
            }
            lazyRemoval();

            medians[start] = findMedian(k);
        }
        return medians;
    }

    private void lazyRemoval() {
        while (!maxHeap.isEmpty() && removedElements.containsKey(maxHeap.peek())
                && removedElements.get(maxHeap.peek()) > 0) {
            Integer removed = maxHeap.poll();
            removedElements.put(removed, removedElements.get(removed) - 1);
        }
        while (!minHeap.isEmpty() && removedElements.containsKey(minHeap.peek())
                && removedElements.get(minHeap.peek()) > 0) {
            Integer removed = minHeap.poll();
            removedElements.put(removed, removedElements.get(removed) - 1);
        }
    }

    private void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double findMedian(int k) {
        if (k % 2 == 0) {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
    }

