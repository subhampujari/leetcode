class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (n == 1) {
            return Collections.singletonList(0);
        }
        if (n == 2) {
            return Arrays.asList(0, 1);
        }
         Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new HashSet<>());
        }
        //adjeency list 
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        } 
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Remove leaves level by level
        while (n > 2) {
            int size = leaves.size();
            n -= size; // Decrease the number of nodes left
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                // The only neighbor of the leaf
                int neighbor = graph.get(leaf).iterator().next();
                // Remove the leaf from the neighbor's list
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    leaves.add(neighbor);
                }
            }
        }

        // Remaining nodes are the roots of minimum height trees
        return new ArrayList<>(leaves);
    }
}