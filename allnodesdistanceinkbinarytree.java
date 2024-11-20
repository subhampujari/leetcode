class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
        // DFS to build the parent map
        buildParentMap(root, null, parentMap);
        
        // Set to track visited nodes
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        
        // Perform DFS to find all nodes within distance K from the target node
        dfs(target, 0, k, parentMap, visited, ans);
        
        return ans;
    }

    // Helper DFS function to collect nodes at distance K
    private void dfs(TreeNode node, int distance, int K, Map<TreeNode, TreeNode> parentMap, Set<TreeNode> visited, List<Integer> ans) {
        if (node == null || visited.contains(node)) {
            return;
        }
        
        visited.add(node);
        
        // If we reached the desired distance, add the node value to the result
        if (distance == K) {
            ans.add(node.val);
            return;
        }
        
        // Recur for left, right, and parent nodes
        if (distance < K) {
            dfs(node.left, distance + 1, K, parentMap, visited, ans);
            dfs(node.right, distance + 1, K, parentMap, visited, ans);
            if (parentMap.containsKey(node)) {
                dfs(parentMap.get(node), distance + 1, K, parentMap, visited, ans);
            }
        }
    }
    public void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
}