class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long upperSum=0;
        long lowerSum=0;
        long secondRobotSum=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            upperSum+=grid[0][i];
        }
             
          for(int i=0;i<n;i++){
             upperSum-=grid[0][i];
           secondRobotSum=Math.min(secondRobotSum,Math.max(upperSum,lowerSum));
            lowerSum+=grid[1][i];
          }
           return secondRobotSum;
    }
}
