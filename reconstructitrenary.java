class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
     // Create the adjacency list using a HashMap and LinkedList
        Map<String, LinkedList<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new LinkedList<>());
            adj.get(from).add(to);
        }
        
        // Sort destinations in lexicographical order for each airport
        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }

        List<String> ans = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK"); // JFK is our fixed starting point

        while (!stack.isEmpty()) {
            String src = stack.peek();
            if (adj.containsKey(src) && !adj.get(src).isEmpty()) {
                // Get the lexicographically smallest destination
                String dst = adj.get(src).pollFirst();
                stack.push(dst);
            } else {
                // No further destinations, add to the result
                ans.add(stack.pop());
            }
        }

        // The result list is in reverse order, reverse it
        Collections.reverse(ans);
        return ans;
    }
}