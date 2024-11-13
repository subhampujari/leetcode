class Solution {
    public int numBusesToDestination(int[][] route, int source, int target) {
       if(source==target)return 0;

       Map<Integer,List<Integer>> map=new HashMap<>();
       for(int i=0;i<route.length;i++){
        for(int num:route[i]){
            map.computeIfAbsent(num,k->new ArrayList<>()).add(i);
        }
       }

       boolean stop[]=new boolean[100000];
       boolean routes[]=new boolean[route.length];

       Queue<Integer> q=new LinkedList<>();
       q.add(source);
       stop[source]=true;
       int busTaken=0;
     
      while(!q.isEmpty()){
        busTaken++;
        int size=q.size();

        for(int i=0;i<size;i++){
           int stops=q.poll();
           for(int routIndex:map.getOrDefault(stops,new ArrayList<>())){
            if(routes[routIndex])continue;

            routes[routIndex]=true;

            for(int nextStop:route[routIndex]){
                if(nextStop==target)return busTaken;
                if(!stop[nextStop]){
                    stop[nextStop]=true;
                    q.add(nextStop);
                }
            }
           }
        }
      }
      return -1;
    }
}