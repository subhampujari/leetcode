class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0;
        int xor2=0;
        if(nums1.length % 2 != 0){
            for(int num:nums2){
                xor1 ^= num;
            }       
    }
          if(nums2.length % 2 !=0){
            for(int num:nums1){
                xor2 ^= num;
            }
          }
        return xor1 ^ xor2;
    }
}