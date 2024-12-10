
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to hold columns, each key maps to another TreeMap to hold rows,
        // and each row maps to a priority queue of node values (min heap)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS (stores node along with its row and column index)
        Queue<Triple> q = new LinkedList<>();
        q.offer(new Triple(root, 0, 0)); // root at row 0, col 0
        
        // BFS to traverse the tree
        while (!q.isEmpty()) {
            Triple triple = q.poll();
            TreeNode node = triple.node;
            int row = triple.row;
            int col = triple.col;
            
            // Add the node value to the corresponding row and column in the map
            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);  // Add node value to priority queue
            
            // Enqueue left child if exists
            if (node.left != null) {
                q.offer(new Triple(node.left, row + 1, col - 1));
            }
            // Enqueue right child if exists
            if (node.right != null) {
                q.offer(new Triple(node.right, row + 1, col + 1));
            }
        }
        
        // Result to store the final vertical order traversal
        List<List<Integer>> res = new ArrayList<>();
        
        // Traverse the map to build the result
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colEntry : map.entrySet()) {
            List<Integer> colList = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> rowEntry : colEntry.getValue().entrySet()) {
                // Add all the node values in the current row to the result list
                while (!rowEntry.getValue().isEmpty()) {
                    colList.add(rowEntry.getValue().poll());  // Poll the smallest value
                }
            }
            res.add(colList);  // Add the current column's result to the overall result
        }
        
        return res;
    }
}

// Helper class to store node, row, and column index
class Triple {
    TreeNode node;
    int row;
    int col;
    
    Triple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

// TreeNode class to represent nodes in the binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}
