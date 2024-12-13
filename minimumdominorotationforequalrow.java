class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topConverstion=rotation(tops,bottoms,tops[0]);
        int bottomConverstion=rotation(tops,bottoms,bottoms[0]);
         if(topConverstion>0 && bottomConverstion>0){
            return Math.min( topConverstion,bottomConverstion);
         }else if(bottomConverstion>0){
            return bottomConverstion;
         }else{
          return topConverstion;
         }
    }
    public int rotation(int[] top,int[] bottom ,int target){
        int min1=0;
        int min2=0;
        for(int i=0;i<top.length;i++){
            if(top[i]!=target && bottom[i]!=target){
                return -1;
            }
             if(top[i]!=target && bottom[i]==target){
                min1++;
            }
            if(top[i]==target && bottom[i]!=target){
                min2++;
            }
        } 
        return Math.min(min1,min2);
    }
}
