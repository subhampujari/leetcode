class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int current=matrix[i][j];

                int down=matrix[i+1][j];
                int downleft=(j>0)?matrix[i+1][j-1]:Integer.MAX_VALUE;//left digonal 
                int downright=(j<n-1)?matrix[i+1][j+1]:Integer.MAX_VALUE;
                matrix[i][j]=matrix[i][j]+Math.min(down,Math.min(downleft,downright));
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res=Math.min(res,matrix[0][i]);
        }
        return res;
    }
}
