class Solution {
    public int totalHammingDistance(int[] nums) {
       int totaldistance=0;
       int n=nums.length;

       //count the all bis in the 31 bit
       for(int i=0;i<32;i++){
        int count=0;
        for(int num:nums){
            if((num&(1<<i))!=0){
                count++;
            }
        }
        totaldistance+=count*(n-count);
       } 
       return totaldistance;
    }
}
