class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean isVist[]=new boolean[rooms.size()];
        int n=rooms.size();
        Stack<Integer> room=new Stack<>();
        room.push(0);
        isVist[0]=true;

        while(!room.isEmpty()){
            int r=room.pop();
            for(int key:rooms.get(r)){
                if(!isVist[key]){
                    isVist[key]=true;
                    room.push(key);
                }
            }
        }

        for(boolean b:isVist){
            if(!b){
                return false;
            }
        }
        return true;
    }
}
