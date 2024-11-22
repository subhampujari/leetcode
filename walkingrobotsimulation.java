class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int res=0;
        int currPos[]={0,0};
        int currDir=0;
        Map<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int obstacl[]:obstacles){
             if(!map.containsKey(obstacl[0])){
                map.put(obstacl[0],new HashSet<>());
             }
             map.get(obstacl[0]).add(obstacl[1]);
        }

        for(int command:commands){
            if(command==-1){
                currDir=(currDir+1)%4;
                continue;
            }
             if(command==-2){
                currDir=currDir-1;
                if(currDir==-1){
                    currDir=3;
                    continue;
                }
            }

            int[] direction=dir[currDir];
            for(int steps=0;steps<command;steps++){
                int newX=currPos[0]+direction[0];
                 int newY=currPos[1]+direction[1];
             if(map.containsKey(newX) && map.get(newX).contains(newY)){
                break;
             }
             currPos[0]=newX;
             currPos[1]=newY;
            }
            res=Math.max(res,currPos[0]*currPos[0]+currPos[1]*currPos[1]);
        }
        return res;
    }
}
