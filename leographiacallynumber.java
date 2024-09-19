class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(n,res,i);
        }
        return res;
    }
    public void dfs(int n,List<Integer> res,int current){
      if(current > n){
        return;//if the number is greater then the given number then return
      }
      res.add(current);//add the number into the list
       for(int i=0;i<=9;i++){//finding thr next number 
        int next=current*10+i;
        if(next > n)return;
        dfs(n,res,next);
       }
    }
}
