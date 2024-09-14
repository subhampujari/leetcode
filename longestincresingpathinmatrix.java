class Solution {
    private  int[][] matrix;
     private int[][] memo;
     private int rows;
     private int cols;
     public int longestIncreasingPath(int[][] matrix) {
         this.matrix=matrix;
         this.rows=matrix.length;
         this.cols=matrix[0].length;
         this.memo=new int[rows][cols];
         //filling the matrix with -1 to cahch the result
         for(int[] row:memo){
             Arrays.fill(row,-1);
         } 
    int maxLength=0;// for the maximum increseing matrix path
    for(int i=0;i<rows;i++){
     for(int j=0;j<cols;j++){
         maxLength=Math.max(maxLength,dfs(i,j));//update the maxlength with the dfs approch by giving the row and col
       }
   }
    return maxLength;
     }
     public int dfs(int row,int col){
         //cheking for if the value of row and col of memo matrix is already completed then return that point
         if(memo[row][col]!=-1){
             return memo[row][col];
         }
        //for the maxLength of the path in matrix
        int maxLength=1;
         //expolring for the next element
         int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
 
         for(int[] direction:directions){
          int newRow=row+direction[0];
          int newCol=col+direction[1];
 
          //cheking the condintion for the nextmaxpath
          if(newRow>=0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]){
             maxLength=Math.max(maxLength,1+dfs(newRow,newCol));
          }
         }
         memo[row][col]=maxLength;
         return maxLength;
     }
 }