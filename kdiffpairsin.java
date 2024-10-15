class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0)return 0;
        //use the hashmap to solve this questions 
        HashMap<Integer,Integer> map=new HashMap<>();

        //add the values to the map
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
int count=0;
        //cheking the number of uniqe k differ pairs 
        for(int num:map.keySet()){
            if(k==0){//if k ===0 the find the num siwch is more than one in the string 
                if(map.get(num)>1){
                    count++;
                }
            }else{
             if(map.containsKey(num+k)){
                count++;
             }

            }
        }
        return count;
    }
}
