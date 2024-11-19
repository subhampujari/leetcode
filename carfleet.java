class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        pair[] Pair=new pair[position.length];

        //inserting into the array
        for(int i=0;i<position.length;i++){
            Pair[i]=new pair(target-position[i],speed[i],1.0*(target-position[i])/speed[i]);
        }

        Arrays.sort(Pair,new Comparator<pair>(){
            public int compare(pair l1,pair l2){
                return l1.distance-l2.distance;
            }
        });

        int fleet=0;
        double prevTime=0.0;

        for(int i=0;i<Pair.length;i++){
           if(Pair[i].time>prevTime){
            fleet++;
            prevTime=Pair[i].time;
           }
        }
return fleet;
    }
}
class pair{
    public double time;
    public int speed;
    public int distance;

    pair(int distance,int speed,double time){
        this.distance=distance;
        this.speed=speed;
        this.time=time;
    }
}
