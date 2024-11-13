class Solution {
    public int racecar(int target) {
       Queue<int[]> q = new LinkedList();
      q.add(new int[]{0,1});
      int moves = 0;
      Comparator<int[]> comparator = (a, b) -> (b[0] - a[0]==0) &&(a[1]-b[1]==0)?0:1;
      TreeSet<int[]> set = new TreeSet<int[]>(comparator);

      while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size;i++){
            int[] cur = q.poll();
            if(set.contains(cur)){
                continue;
            }
            set.add(cur);
            if(cur[0]==target){
                return moves;
            }
            q.add(new int[]{cur[0]+cur[1],cur[1]*2});
            if ((cur[0]+cur[1] > target && cur[1] > 0) || (cur[0]+cur[1] < target && cur[1] < 0)) {
                q.add(new int[]{cur[0], cur[1] > 0? -1: 1 });
            }
            // q.add(new int[]{cur[0], cur[1]>0?-1:1});
        }
        moves++;
      }
      return -1;
    }
}