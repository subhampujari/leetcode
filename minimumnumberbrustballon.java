class Solution {
    public int findMinArrowShots(int[][] points) {
      if(points.length==0){
        return 0;
      }  
  //sort the array on the basisi of end point 
 Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));

  int arrows=1;//start with 1 array
  int compareEnd=points[0][1];//compare with the end point the 
  for(int i=1;i<points.length;i++){
     // If the start of the current balloon is greater than the current end
    if(points[i][0]>compareEnd){
        arrows++;//increase the arrows
        compareEnd=points[i][1];// store the point of that end point 
    }
  }

return arrows;
    }
}
