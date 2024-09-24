class Solution {
    public int countBattleships(char[][] board) {
        int battleship=0;//varaible for finding the number of battelship
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    battleship++;
                    dfs(board,i,j);
                }
            }
        }
      return battleship;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='X'){
            return;
        }//cheking the exceptions occur 
        board[i][j]='*';

        //the possible 4 directions
        dfs(board,i-1,j);
          dfs(board,i,j-1);
            dfs(board,i+1,j);
              dfs(board,i,j+1);
    }
}