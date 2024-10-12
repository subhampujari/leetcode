class Solution {
    private Map<Integer, Integer> countMap = new HashMap<>();
   private int maxCount = 0;
   public int[] findMode(TreeNode root) {
       // Traverse the BST to count occurrences of each value
       inOrderTraversal(root);
       
       // Find the maximum frequency
       List<Integer> modes = new ArrayList<>();
       for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
           if (entry.getValue() == maxCount) {
               modes.add(entry.getKey());
           }
       }

       // Convert the list of modes to an array
       int[] result = new int[modes.size()];
       for (int i = 0; i < modes.size(); i++) {
           result[i] = modes.get(i);
       }
       return result;
   }
    private void inOrderTraversal(TreeNode node) {
       if (node == null) {
           return;
       }

       // Left subtree
       inOrderTraversal(node.left);
       
       // Current node
       countMap.put(node.val, countMap.getOrDefault(node.val, 0) + 1);
       maxCount = Math.max(maxCount, countMap.get(node.val));
       
       // Right subtree
       inOrderTraversal(node.right);
   }
}
