class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int Area = 0;
        int bottomr = Integer.MAX_VALUE;
        int bottomc = Integer.MAX_VALUE;
        int topr = Integer.MIN_VALUE;
        int topc = Integer.MIN_VALUE;
       Set<String> points=new HashSet<>();
        for (int[] res : rectangles) {
           int width=res[2]-res[0];
           int height=res[3]-res[1];
           Area+=width*height;
            // Track the bounding box
           bottomr = Math.min(bottomr, res[0]);
           bottomc = Math.min(bottomc, res[1]);
            topr = Math.max(topr, res[2]);
           topc= Math.max(topc, res[3]);

        // The area of the bounding rectangle
       process(points,res[0],res[1]);
         process(points,res[0],res[3]);
           process(points,res[2],res[1]);
              process(points,res[2],res[3]);
    }
    int grandArea= ( topr-bottomr)*(topc-bottomc);
    System.out.println(Area+"as?"+grandArea);
    if(Area!=grandArea){
        return false;
    }
    return points.contains(bottomr+"_"+bottomc) && points.contains(bottomr+"_"+topc) && points.contains(topr+"_"+bottomc) && points.contains(topr+"_"+topc) && points.size()==4;
    }

    private void process( Set<String> points, int x, int y) {
        String key = x + "_" + y;
      if(points.add(key)==false){
        points.remove(key);
      }
    }
}