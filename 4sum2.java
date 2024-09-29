class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       //step 1 for the find the sum of each number of first two array 
       Map<Integer,Integer> fMap=new HashMap<>();
       int count=0;

       for(int num1:nums1){
        for(int num2:nums2){
            int sum=num1+num2;
            fMap.put(sum,fMap.getOrDefault(sum,0)+1);
        }
       } 
      //find the next sum for last 2 array and cheking if the num is preset then addelse not
      for(int num3:nums3){
        for(int num4:nums4){
            int target=-(num3+num4);
            count+=fMap.getOrDefault(target,0);
        }
      }
return count;
    }
}