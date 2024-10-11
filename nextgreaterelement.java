class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        //traversing in the 2 array and push into the map
        for(int num:nums2){
            //if the cuurent num is greater than stack peek then pop from the stack addinto the map
            while(!st.isEmpty() && num > st.peek()){
                map.put(st.pop(),num);
            }
            st.push(num);
        }

        //after the avove operation the remaining elemnts in the stack are no greater element 
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }

        //adding into the array wich have the next greater element 
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}