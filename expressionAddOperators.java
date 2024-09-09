class Solution {
    public List<String> addOperators(String num,int target) {
        List<String> res=new ArrayList<>();
        if(num==null||num.length()==0){
            return res;
        }
        backTrack(res,new StringBuilder(),num,target,0,0,0);//backtracking
        return res;
    }
    public void backTrack( List<String> res,StringBuilder path,String num,int target,int index,long eval,long mult){
        if(index==num.length()){
            if(target==eval){//if tarteget is equal to the evalution 
                res.add(path.toString());
            }
            return ;
        }
        for(int i=index;i<num.length();i++){
            if(i!=index && num.charAt(index)=='0'){
                break;//igone the leading zeores
            }
   long curr=Long.parseLong(num.substring(index,i+1));
   int len=path.length();
   if(index==0){//first expressuion uin the striing 
    backTrack(res,path.append(curr),num,target,i+1,curr,curr);
    path.setLength(len);//setting the lenght of path
   }
   else{
    //addition
    backTrack(res,path.append("+").append(curr),num,target,i+1,eval+curr,curr);
    path.setLength(len);
    //subtraction
    backTrack(res,path.append("-").append(curr),num,target,i+1,eval-curr,-curr);
    path.setLength(len);
    //multipliacion
    backTrack(res,path.append("*").append(curr),num,target,i+1,eval - mult + mult * curr,mult*curr);
    path.setLength(len);
   }
        }
    }
}
