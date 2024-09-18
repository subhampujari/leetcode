class Solution {
    // to solve this question we can use the priority queue
    class pair{
       int value;
        int row;
        int col;
        public pair(int value,int row,int col ){
            this.value=value;
            this.row=row;
            this.col=col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.value-b.value);
           
           //adding the first column in the priorityqueue and after that exploring the next column
           for(int i=0;i<Math.min(k,n);i++){
            q.offer(new pair(matrix[i][0],i,0));
           }
            
            //finding the k elemnts in the queue
            pair elemnt=null;
            for(int i=0;i<k;i++){
              elemnt=q.poll();
              int row=elemnt.row;
              int col=elemnt.col;

              //adding the next col 
              if(col+1 < n){
              q.offer(new pair(matrix[row][col+1],row,col+1));
            }
            }
            return elemnt.value;
    }
}