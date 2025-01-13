class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find the minimum and maximum edge weights
        for (int[] edge : edges) {
            min = Math.min(edge[2], min);
            max = Math.max(edge[2], max);
        }

        int ans = -1;
        int l = min;
        int h = max;

        // Binary search on the edge weight to find the minimal weight that satisfies the condition
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(n, edges, mid)) {
                ans = mid;
                h = mid - 1; // Search in the lower half
            } else {
                l = mid + 1; // Search in the upper half
            }
        }
        return ans;
    }

    public boolean isPossible(int n, int[][] edges, int target) {
        // Adjacency list to store the graph
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // Build the graph by adding edges with weight <= target
        for (int[] edge : edges) {
            if (edge[2] <= target) {
                list.get(edge[1]).add(edge[0]); // Since it's an undirected graph
            }
        }

        // Perform BFS to check if all nodes can be visited
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;

        int count = 1; // Start with 1 since node 0 is already visited
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : list.get(curr)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        // If all nodes are visited, return true
        return count == n;
    }
}
