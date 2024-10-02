class Solution {
    public boolean makesquare(int[] matchsticks) {
         //we can solve this question using the backtrack approach 
     int totallength=0;
     for(int i:matchsticks){
        totallength+=i;
     }
  //if the total length %4 is not equal by 4 then return false
        if(totallength % 4 !=0)return false;
       
            //calulate the side value by divaide 4
            int sidesLength=totallength/4;
            //sort the array 
            Arrays.sort(matchsticks);

            //reverse the point 
            reverse(matchsticks);
       return backtrack(matchsticks,new int[4] ,0,sidesLength);
    }
    private void reverse(int[] matchsticks) {
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }
    }

   private boolean backtrack(int[] matchsticks,int[] sides ,int index,int sideLength){
    if(index==matchsticks.length){
        //if all the sides are equal to the sidelength then return true or else false
        return sides[0]==sideLength && sides[1]==sideLength && sides[2]==sideLength && sides[3]==sideLength;  
    }
     //exploring the all sides
     for(int i=0;i<4;i++){
        //adding the sidelengthinto the sides and cheking the its less than or equal to the matchesStick[i]
        if(sides[i]+matchsticks[index]<=sideLength){
            sides[i]+=matchsticks[index];

            if(backtrack(matchsticks,sides,index+1,sideLength)){//recursion for the next index 
                return true;
            }
            //baktrak 
            sides[i]-=matchsticks[index];
        }

//if any point sides[i]==0 then break
if(sides[i]==0){
    break;
}
     }
return false;
   }
    
}
