class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we can solve the question using DfS or toplogical sort 
      List<List<Integer>> graph=new ArrayList<>();//creat one graph
      //creat the recursion stack and visitetd stack
      boolean [] isVisit=new boolean[numCourses];
      boolean [] recStack=new boolean[numCourses];
      //adding the adjjency list to the graph
      for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
      }
     //add the course into the graph
     for(int[] preCourse:prerequisites){
        graph.get(preCourse[1]).add(preCourse[0]);
     }
      // to track the course is have the cycle or not 
      for(int i=0;i<numCourses;i++){
        if(!isVisit[i]){// if  the node is not visi 
            if(dfs(graph,i,isVisit,recStack)){
                return false;// cycle is detctetd
            }
        }
      }
      return true;// no cycle is dtetct and course has completed 
    }
    //Dfs for detact the cycle 
    public boolean dfs(List<List<Integer>> graph,int node,boolean [] isVisit, boolean [] recStack){
        if(recStack[node]){
            return true;// if the node is already visited in recursion stack then reurn true that cycle detect
        }

        if(isVisit[node]){
            return false;// node has fully not processed
        }

        isVisit[node]=true;//mark as it true
        recStack[node]=true;//mark in rec stack

        for(int neghibour:graph.get(node)){
            if(dfs(graph,neghibour,isVisit,recStack)){
                return  true;// return true that cycle has detct
            }
        }
        recStack[node]=false;//made the recStack as false while returning
        return false;//that there is no cycle
    } 

}