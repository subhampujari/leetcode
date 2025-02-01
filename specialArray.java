class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        if(n==1)return true;
        for(int i=0;i<n;i++){
            if( i+1 < n && nums[i]%2==0 ){// this is the case of even
                if(nums[i+1]%2!=0){
                    continue;
                }else{
                    return false;
                }
            }
             if( i+1 < n && nums[i]%2!=0 ){// this is the case of even
                if(nums[i+1]%2==0){
                    continue;
                }else{
                    return false;
                }
            }
        }
         return true;
    }
}
