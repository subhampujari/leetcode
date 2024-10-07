class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        generateSubSet(0,nums,new ArrayList<>(), res);
        return res;
    }
    private void generateSubSet(int idx,int []nums,List<Integer> curr,List<List<Integer>> res){
     res.add(new ArrayList<>(curr));//add the number into the result starting 
     for(int i=idx;i<nums.length;i++){
        curr.add(nums[i]);
         generateSubSet(i+1,nums,curr,res);//recursion
         curr.remove(curr.size()-1);//backtrackng
     }
    }
}