class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> mergeByVertical=buildMergeInterval(rectangles,true);
        if(mergeByVertical.size()>=3){
            return true;
        }

        List<int[]> mergeByHoriZental=buildMergeInterval(rectangles,false);
        if(mergeByHoriZental.size()>=3){
            return true;
        }
        return false;
    }

    public List<int[]> buildMergeInterval(int[][]rectangles,boolean isVertical){
        List<int[]> interval=new ArrayList<>();
        for(int [] rect:rectangles){
            interval.add(isVertical?new int[]{rect[0],rect[2]}:new int[]{rect[1],rect[3]});
        }

        //sort the interval
        interval.sort(Comparator.comparingInt(a->a[0]));

         List<int[]> merged=new ArrayList<>();
         int[] current=interval.get(0);
         for(int i=1;i<interval.size();i++){
            int []next=interval.get(i);
            if(current[1]>next[0]){
                current[1]=Math.max(current[1],next[1]);
            }else{
                merged.add(current);
                current=next;
            }
         }
       merged.add(current);
       return merged;
    }
}
