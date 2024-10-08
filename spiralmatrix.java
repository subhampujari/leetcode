class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();//for retruning the answer
        if(matrix.length==0)return new ArrayList<>();
         int rowBegin=0;
         int rowEnd=matrix.length-1;
         int colBegin=0;
         int colEnd=matrix[0].length-1;
         while(rowBegin<=rowEnd && colBegin<=colEnd){
            //traversing for the left to right 
            for(int i=colBegin;i<=colEnd;i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //traversing for the top to batom
            for(int i=rowBegin;i<=rowEnd;i++ ){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin<=rowEnd){
                for(int i=colEnd;i>=colBegin;i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colBegin<=colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
         }
         return res;

  }
}
    
