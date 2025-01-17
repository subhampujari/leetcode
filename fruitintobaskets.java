class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int maxFruit=0;
        Map<Integer,Integer> map=new HashMap<>();

        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxFruit=Math.max(maxFruit,right-left+1);
        }
        return maxFruit;
    }
}
