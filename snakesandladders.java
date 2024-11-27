class Solution {
    public int snakesAndLadders(int[][] board) {
       int n=board.length;
        Queue<Integer> q=new LinkedList<>();
        boolean isVist[][]=new boolean[n][n];
        q.add(1);
        isVist[n-1][0]=true;
        int minSteps=0;
        while(!q.isEmpty()){
        int size=q.size();
        while(size-->0){
            int currValue=q.poll();
            if(currValue==n*n)return minSteps;
            for(int diceValue=1;diceValue<=6;diceValue++){
                if(diceValue+currValue>n*n)continue;
                int []pos=findCordinates(diceValue+currValue,n);
                int row=pos[0];
                int col=pos[1];

                if(isVist[row][col]==true)continue;

                isVist[row][col]=true;

                if(board[row][col]==-1)q.add(diceValue+currValue);
                else q.add(board[row][col]);
            }
        }
minSteps++;
        }
        return -1;
    }
    public int[] findCordinates(int currValue,int n){
      int r=n-(currValue-1)/n-1;
      int c=(currValue-1) % n;

      if(r%2==n%2)return new int[]{r,n-1-c};
      else return new int[]{r,c};
    }
}