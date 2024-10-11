class Solution {
    public Map<String,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        // we can solve this question using the dynamic programming and Backtracking
        map=new HashMap<>();
        return targetSum(nums,0,target);
    }
    public int targetSum(int[] nums,int index,int target){
        //if we reach the end of the array 
        if(nums.length==index){
            return target==0 ? 1:0;
        }
        //create one unique String for the findg the result
        String key=index+","+target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        //try the add and subtract of the target
        int add=targetSum(nums,index+1,target-nums[index]);
        int subtract=targetSum(nums,index+1,target+nums[index]);

      //cach the string key
      map.put(key,add+subtract);
      return map.get(key);
    }
}