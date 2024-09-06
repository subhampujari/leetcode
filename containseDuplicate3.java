class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // we can silve this question by using the treeSet
        if(indexDiff<=0 || valueDiff< 0)return false;

        TreeSet<Long> tr=new TreeSet<>();

        for(int i=0;i<nums.length;i++){

            if(i >  indexDiff){
                tr.remove((long)nums[i-indexDiff-1]);// decerse the slide 
            }
         
         Long floor=tr.floor((long) nums[i]+valueDiff);

         Long celling= tr.ceiling((long) nums[i]-valueDiff);

         if(floor!=null && floor>=(long) nums[i]-valueDiff){
            return true;
         }
         if(celling!=null && celling <=(long) nums[i]+valueDiff ){
            return true;
         }
        tr.add((long)nums[i]);

        }
  return  false;
    }
}
