class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         // Build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(new int[] {to, price});
        }

        // Priority Queue to perform BFS-like traversal
        // The queue will store {cost, city, stops}
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[] {0, src, 0}); // {cost, city, stops}
        
        // To store the minimum cost to reach a city with at most `k` stops
        int[][] minCost = new int[n][k + 2];  // n cities, k + 1 stops
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;  // starting city with 0 cost and 0 stops
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];
            
            // If we've already exceeded k stops, don't process further
            if (stops > k) continue;

            // Explore neighbors (outgoing flights)
            if (graph.containsKey(city)) {
                for (int[] neighbor : graph.get(city)) {
                    int nextCity = neighbor[0];
                    int price = neighbor[1];
                    int newCost = cost + price;
                    
                    // If the new cost is cheaper or we haven't visited this city with fewer stops, add to queue
                    if (newCost < minCost[nextCity][stops + 1]) {
                        minCost[nextCity][stops + 1] = newCost;
                        pq.offer(new int[] {newCost, nextCity, stops + 1});
                    }
                }
            }
        }
        
        // Find the minimum cost to reach dst with at most k stops
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            result = Math.min(result, minCost[dst][i]);
        }
        
        // If result is still Integer.MAX_VALUE, it means no valid route exists
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}