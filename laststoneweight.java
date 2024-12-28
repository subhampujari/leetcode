class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);//max heap 
      //insert all the elements into the heap
      for(int i=0;i<stones.length;i++){
        pq.offer(stones[i]);
      }

      while(pq.size()>1){
        int yStone=pq.poll();
        int xStone=pq.poll();

        //if any point the ary equal then continue the itreation 
        if(yStone==xStone)continue;
        else{
            yStone=yStone-xStone;
            pq.offer(yStone);
        }
      }
      return pq.isEmpty() ? 0 : pq.poll();
    }
}
