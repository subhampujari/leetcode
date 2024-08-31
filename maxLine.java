class Solution {
    public int maxPoints(int[][] points) {
       if(points.length==0)return 0;
       int max=0;
       for(int [] x:points){
        Map<Double,Integer> map=new HashMap<>();
        for(int[] y:points){
            double slope;
            if(x==y)continue;
            if(x[0]==y[0]){// if x and y cordinate of 0 th value are equal then store postivi infinty
               slope = Double.POSITIVE_INFINITY;
            }else{
           slope=(y[1]-x[1])/(double)(y[0]-x[0]);
            }
           map.put(slope, map.getOrDefault(slope, 0) + 1);
            max=Math.max(max,map.get(slope));
        }
       }
       return max+1;
    }
}
