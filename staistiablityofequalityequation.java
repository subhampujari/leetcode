class Solution {
    public boolean equationsPossible(String[] equations) {
        int parent[]=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
          for(String equation:equations){
            char equality=equation.charAt(1);
            if(equality=='='){
                int val1=findParent(equation.charAt(0)-'a',parent);
                int val2=findParent(equation.charAt(3)-'a',parent);
                if(val1!=val2){
                    parent[val2]=val1;
                }
            }
          }
 for(String equation:equations){
            char equality=equation.charAt(1);
            if(equality=='!'){
                int val1=findParent(equation.charAt(0)-'a',parent);
                int val2=findParent(equation.charAt(3)-'a',parent);
                if(val1==val2){
                   return false;
                }
            }
          }
return true;
    }
public int findParent(int index,int[]parent){
   if(parent[index]==index) return index;
     return findParent(parent[index],parent);
} 
}
