class SummaryRanges {
    private Set<Integer> number;
  public SummaryRanges() {
      number=new TreeSet<>();
  }
  
  public void addNum(int value) {
      number.add(value);
  }
  
  public int[][] getIntervals() {
      // we have to create one array of arraylist
      List<int[]> disjointset=new ArrayList<>();
      for(int num:number){
          int size=disjointset.size();
          if(size > 0 && disjointset.get(size-1)[1]+1==num){
              disjointset.get(size-1)[1]=num;// merge the intervals
          }else{
              disjointset.add(new int[]{num,num});
          }
      }
      return disjointset.toArray(new int[0][]);
  }
}

/**
* Your SummaryRanges object will be instantiated and called as such:
* SummaryRanges obj = new SummaryRanges();
* obj.addNum(value);
* int[][] param_2 = obj.getIntervals();
*/