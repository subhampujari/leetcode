class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res=new ArrayList<>();
        if(matrix==null && matrix.length==0 || matrix[0].length==0){
            return res;
        }

        int row=matrix.length;
        int col=matrix[0].length;
        boolean [][] pasfic=new boolean[row][col];//matix for the pasfic ocean
        boolean [][] atlatic=new boolean[row][col];//matrix for the atlatic ocean 

        //dfs appraoch for the corners of first and last row
        for(int i=0;i<col;i++){
            dfs(matrix,0,i,Integer.MIN_VALUE,pasfic);
             dfs(matrix,row-1,i,Integer.MIN_VALUE,atlatic);
        }
        
        //dfs approach for the first and last column
         for(int i=0;i<row;i++){
            dfs(matrix,i,0,Integer.MIN_VALUE,pasfic);
             dfs(matrix,i,col-1,Integer.MIN_VALUE,atlatic);
        }
        //fillng the answer list for the index wich have bothe direction to flow of water
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pasfic[i][j] && atlatic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
return res;
    }

    //dfs approach
    public void dfs(int[][] matrix,int i,int j,int prev,boolean [][]ocean){
     //cheking the boundrycondition 
     if(i<0 || j<0 || i>=ocean.length || j>=ocean[0].length )return;
     if(matrix[i][j] < prev || ocean[i][j])return;//if we already visit the place then retuirn
     //exploer the four directions
     ocean[i][j]=true;
     for(int[] d:dir){
        dfs(matrix,i+d[0],j+d[1],matrix[i][j],ocean);
     }

    }
}}
