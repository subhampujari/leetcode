class Solution {
    private int max=0;
    private Map<Integer,Integer>  map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        calulateTheSubtreeSum(root);

        List<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==max){
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public int calulateTheSubtreeSum(TreeNode root){
        if(root==null){
            return 0;
        }

        //left node and riht node 
      int left= calulateTheSubtreeSum(root.left);
       int right= calulateTheSubtreeSum(root.right);

       int total=root.val+left+right;

       //adding into the map 
       map.put(total,map.getOrDefault(total,0)+1);
       max=Math.max(max,map.get(total));

       return total;
    }
}
