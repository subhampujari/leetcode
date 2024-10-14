class Solution {
    public int findMinMoves(int[] machines) {
         int n = machines.length;
       int sum=0;
       for(int v:machines){
        sum+=v;
       }

       if(sum % n !=0){
        return -1;
       }

       int eachShouldHave=sum/n;

       int res=0;
       int leftHave=0;
       int rightHave=sum;
       for(int i=0;i!=machines.length;i++){
      int busyturn=0;
      int leftItems=i+1;
      leftHave+=machines[i];
      int LeftEachhave=leftItems*eachShouldHave;

      if(leftHave>LeftEachhave){
        busyturn+=leftHave-LeftEachhave;
      }
      int rightItems=machines.length-i;
      int rightEachHave=rightItems*eachShouldHave;
    if(rightHave>rightEachHave){
        busyturn+=rightHave-rightEachHave;
      }
   rightHave-=machines[i];
  res=Math.max(res,busyturn);
       }
       return res;
    }
}