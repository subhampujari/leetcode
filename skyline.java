class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
     List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();
        
        // Collect all the events
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            // Add start and end events
            events.add(new int[]{left, -height}); // start of building
            events.add(new int[]{right, height}); // end of building
        }
        
        // Sort events
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        // Max-Heap to keep track of the current heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        int prevMaxHeight = 0;
        
        for (int[] event : events) {
            int x = event[0];
            int height = event[1];
            
            if (height < 0) {
                // This is a building start event
                maxHeap.add(-height);
            } else {
                // This is a building end event
                maxHeap.remove(height);
            }
            
            int currentMaxHeight = maxHeap.peek();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        
        return result;
    }
}