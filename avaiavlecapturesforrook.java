class Solution {
    public int numRookCaptures(char[][] board) {
        int attack=0;
        int row=-1;
        int col=-1;
        //find the postion of the rook
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    row=i;
                    col=j;
                    break;
                }
            }
            if(row!=-1)break;
        }

        //upword direction of rrok
        for(int j=row-1;j>=0;j--){
            if(board[j][col]=='B')break;
            if(board[j][col]=='p'){
                attack++;
                break;
            }
        }

    //downword direction 
           for(int j=row+1;j<8;j++){
            if(board[j][col]=='B')break;
            if(board[j][col]=='p'){
                attack++;
                break;
            }
        }
     //left direction
      for(int j=col-1;j>=0;j--){
            if(board[row][j]=='B')break;
            if(board[row][j]=='p'){
                attack++;
                break;
            }
        }

        //right direction 
         for(int j=col+1;j<8;j++){
            if(board[row][j]=='B')break;
            if(board[row][j]=='p'){
                attack++;
                break;
            }
        }
        return attack;
    }
}
