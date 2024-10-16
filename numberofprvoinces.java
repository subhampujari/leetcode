class Solution {
    public int findCircleNum(int[][] isConnected) {
        // we can solve this question using the dfs as well as the bfs
        int n=isConnected.length;
     boolean isVist[]=new boolean[n+1];
   int provinces=0;
   for(int i=0;i<n;i++){
    if(!isVist[i]){
        provinces++;
        dfs(isConnected,isVist,i);
    }
   }
   return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] isVist,int i){
        isVist[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !isVist[j]){
                dfs(isConnected,isVist,j);
            }
        }
    }
}