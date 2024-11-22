class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++){
            if(piles[i]>end){
                end=piles[i];
            }
        }

        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[]piles,int mid,int h){
        int hourSpent=0;
        for(int i=0;i<piles.length;i++){
            hourSpent+=piles[i]/mid;
            if(piles[i]%mid!=0){
                hourSpent+=1;
            }
            if(hourSpent>h){
                return false;
            }
        }
        return true;
    }
}
