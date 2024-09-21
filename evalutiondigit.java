class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //to solve this question using the  DFS approch with backtracking
        HashMap<String,HashMap<String ,Double>> map=new HashMap<>();
        for(int i=0;i<equations.size();i++){///creating the adjency list 
            String divdend=equations.get(i).get(0);//finding the divedend 
            String divisior=equations.get(i).get(1);//finding the divisior
            double res=values[i];//the value of division 
            if(!map.containsKey(divdend)){
                map.put(divdend,new HashMap<String,Double>());
            }
            if(!map.containsKey(divisior)){
                map.put(divisior,new HashMap<String,Double>());
            }
            map.get(divdend).put(divisior,res);
            map.get(divisior).put(divdend,1/res);
        } 
        //solving the  queries 
        double [] res=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
             String divdend=queries.get(i).get(0); 
            String divisior=queries.get(i).get(1);
            if(!map.containsKey(divdend)||!map.containsKey(divisior)){//if one of them is not present then put int the array as -1
                res[i]=-1.0;
            }else if(divdend.equals(divisior)){//if the divdend and divisior are equal then put 1
                res[i]=1.0;
            }else{
                HashSet<String> visit=new HashSet<>();
                res[i]=dfs(divdend,divisior,1,visit,map);//else dfs call for the next edge
            }
        }
        return res;
    }
    //dfs approach 
  public double dfs(String src,String target,double prod, HashSet<String> visit,HashMap<String,HashMap<String ,Double>> map){
    double ret=-1;
    visit.add(src);
      if(map.get(src).containsKey(target)){
        ret=map.get(src).get(target)*prod;
      }else{
        for(String next:map.get(src).keySet()){
            if(!visit.contains(next)){
                ret=dfs(next,target,prod*map.get(src).get(next),visit,map);
                if(ret!=-1){
                    break;
                }
            }
        }
      }

    visit.remove(src);//backtracking
    return ret;
  }
}
