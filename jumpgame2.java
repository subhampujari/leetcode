class Solution {
    public int jump(int[] nums) {
        //for doing we can use the greeady approch for solving 
        if(nums.length==0)return 0;
        if(nums.length==1)return 0;
        int n=nums.length;
        int jump=0;//for how much jump requried to doing 
        int correntEnd=0;
        int fatestEnd=0;
   for (int i=0;i<n;i++){
    fatestEnd=Math.max(fatestEnd,i+nums[i]);//updating the faster point
    if(i==correntEnd){
        jump++;//calulating the jump
        correntEnd=fatestEnd;//updating the corrent end
        if(correntEnd>=n-1)break;//if when we comes to the end of the array then break and return the numbbers of jumps
    }
   }
   return jump;
    }
}
