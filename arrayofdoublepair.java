class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr==null || arr.length==0)return true;
        Arrays.sort(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
            for(int num:arr){
                map.put(num,map.getOrDefault(num,0)+1);
            }

            for(int num:arr){
                if(map.get(num)==0)continue;
                //chekin for the odd eneagtive pair 
                if(num<0 && num%2!=0){
                    return false;
                }

                int target=  (num<0)?num/2:num*2;

                if(map.getOrDefault(target,0)<=0){
                    return false;
                }
                map.put(num,map.get(num)-1);
                  map.put(target,map.get(target)-1);
            }
            return true;
    }
}
