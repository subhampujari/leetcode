class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero=0;
        int stRow=0;
        int stCol=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    zero++;
                }else if(grid[i][j]==1){
                    stRow=i;
                    stCol=j;
                }
            }
        }

        return dfs(grid,stRow,stCol,zero);
    }
    public int dfs(int[][]grid,int row,int col,int zero){
        if(row<0 || col<0 || col>=grid[0].length ||row>=grid.length ||grid[row][col]==-1){
            return 0;
        }
        if(grid[row][col]==2){
            return zero==-1?1:0;
        }
        grid[row][col]=-1;//mark this as visted 
        zero--;//decrease the zero
        int totalPath=dfs(grid,row+1,col,zero)+dfs(grid,row,col+1,zero)+dfs(grid,row,col-1,zero)+dfs(grid,row-1,col,zero);
          grid[row][col]=0;
          zero++;

          return totalPath;
    }
}
