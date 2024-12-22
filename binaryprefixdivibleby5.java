class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res=new ArrayList<>();
        int curr=0;
        for(int num:nums){
            curr=(curr*2+num)%10;
            res.add(curr==0|| curr==5);
        }
        return res;
    }
}
