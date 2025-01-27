import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // we can solve this question using various way like tree traversal and khans algo and flyod algo
        boolean isPrereqeuisties[][]=new boolean[numCourses][numCourses];
        for(int pre[]:prerequisites){
            isPrereqeuisties[pre[0]][pre[1]]=true;
        }

        for(int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                for(int k=0;k<numCourses;k++){
                    isPrereqeuisties[j][k]=isPrereqeuisties[j][k] || (isPrereqeuisties[j][i] && isPrereqeuisties[i][k]);//If there is a path i -> intermediate and intermediate -> j, then i -> j exists as well.
                }
            }
        }
             List<Boolean> ans=new ArrayList<>();
             for(int query[]:queries){
                ans.add( isPrereqeuisties[query[0]][query[1]]);
             }
             return ans;
    }
}
