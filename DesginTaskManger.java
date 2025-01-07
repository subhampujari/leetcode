class TaskManager {
    private static class Task implements Comparable<Task>{
           int userId,taskId, priority;
          Task(int userId,int taskId,int priority){
             this.userId=userId;
             this.taskId=taskId;
             this.priority=priority;
          }
          @Override
          public int compareTo(Task other){
             if(this.priority!=other.priority){
                 return Integer.compare(other.priority,this.priority);
             }
             return Integer.compare(other.taskId,this.taskId);
          }
    }
    private final TreeMap<Task,Integer> treeMap;
    private final Map<Integer,Task> map;
     public TaskManager(List<List<Integer>> tasks) {
         treeMap=new TreeMap<>();
         map=new HashMap<>();
         for(List<Integer> task:tasks){
             int userId=task.get(0),taskId=task.get(1),priority=task.get(2);
             add(userId,taskId,priority);
         }
     }
     
     public void add(int userId, int taskId, int priority) {
         Task task=new Task(userId,taskId,priority)Z;
         treeMap.put(task,userId);
         map.put(taskId,task);
     }
     
     public void edit(int taskId, int newPriority) {
         Task task=map.get(taskId);
         if(task!=null){
             treeMap.remove(task);
             task.priority=newPriority;
             treeMap.put(task,task.userId);
         }
     }
     
     public void rmv(int taskId) {
         Task task=map.get(taskId);
         if(task!=null){
             treeMap.remove(task);
             map.remove(taskId);
         }
     }
     
     public int execTop() {
         if(treeMap.isEmpty()){
           return -1;
         }
         Task topTask=treeMap.firstKey();
         treeMap.remove(topTask);
         map.remove(topTask.taskId);
         return topTask.userId;
     }
 }
