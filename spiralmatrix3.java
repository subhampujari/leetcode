class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};//durections to move in spiral order
        int count=1;
        int n=rows*cols;
        int res[][]=new int[n][2];
        int steps=1;
        res[0][0]=rStart;
        res[0][1]=cStart;
        int index=0;
        while(count<n){
            for(int times=0;times<2;times++){
                int dr=dir[index%4][0];
                 int dc=dir[index%4][1];
                 for(int i=0;i<steps;i++){
                    rStart+=dr;
                    cStart+=dc;
                    if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                        res[count][0]=rStart;
                        res[count][1]=cStart;
                        count++;
                    }
                 }
                 index++;
            }
            steps++;
        }
return res;
    }
}
