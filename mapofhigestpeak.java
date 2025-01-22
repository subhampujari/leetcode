class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;

        int [][]height=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int []row:height){
            Arrays.fill(row,-1);
        }

        // put all the water cell or 1 cell to the queue and mark as visted 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    q.offer(new int[]{i,j});
                    height[i][j]=0;
                }
            }
        }
         int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};

         while(!q.isEmpty()){
            int curr[]=q.poll();
            for(int d[]:dir){
                int newRow=curr[0]+d[0];
                int newCol=curr[1]+d[1];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && height[newRow][newCol]==-1){
                    height[newRow][newCol]=height[curr[0]][curr[1]]+1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
         }
        return height;
    }
}
