class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {//create one adjancy list
        // Step 1: Build the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Step 2: Set up the priority queue and distance map
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{k, 0}); // {node, time}
        
        Map<Integer, Integer> minTime = new HashMap<>();
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0];
            int time = curr[1];

            // If this node was already reached with a smaller time, skip it
            if (minTime.containsKey(node)) continue;
            minTime.put(node, time);

            // Step 3: Update neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int travelTime = neighbor[1];
                    if (!minTime.containsKey(nextNode)) {
                        minHeap.offer(new int[]{nextNode, time + travelTime});
                    }
                }
            }
        }

        // Step 4: Check if all nodes were reached
        if (minTime.size() < n) return -1;

        // Step 5: Return the maximum time taken for all nodes to receive the signal
        return Collections.max(minTime.values());
    }
}
