class RandomizedCollection {
    private ArrayList<Integer> list; // To store the elements
       private HashMap<Integer, HashSet<Integer>> map; // Value -> set of indices in the list
       private Random random;
   
       public RandomizedCollection() {
           list = new ArrayList<>();
           map = new HashMap<>();
           random = new Random();
       }
       
       public boolean insert(int val) {
        boolean ispresent=!map.containsKey(val);
   
        list.add(val);//add the element in the list
        map.putIfAbsent(val,new HashSet<>());//if absent of the element then add a new hashset
        map.get(val).add(list.size()-1);//if it exist then add the value in the index of set
   return ispresent;
       }
       
       public boolean remove(int val) {
           //base case if it is not exist in the map then return as directlyu false
           if(!map.containsKey(val) || map.get(val).isEmpty()){
               return false;
           }
            //finding the index of the val
            int indexOfVal=map.get(val).iterator().next();
            //removing from set if the value is exist more then one
            map.get(val).remove(indexOfVal);
            //if the value is only one or no more duplicate of that value then remove that number from also map
           if(map.get(val).isEmpty()){
               map.remove(val);
            }
       
       //recorrect the index of the index in list and map also
       int lastElement=list.get(list.size()-1);
       if(indexOfVal!=list.size()-1){
           list.set(indexOfVal,lastElement);
           map.get(lastElement).remove(list.size()-1);
           map.get(lastElement).add(indexOfVal);
       }
       list.remove(list.size()-1);
       return true;
       }
       
       public int getRandom() {
           return list.get(random.nextInt(list.size()));
       }
   }
   
   /**
    * Your RandomizedCollection object will be instantiated and called as such:
    * RandomizedCollection obj = new RandomizedCollection();
    * boolean param_1 = obj.insert(val);
    * boolean param_2 = obj.remove(val);
    * int param_3 = obj.getRandom();
    */
