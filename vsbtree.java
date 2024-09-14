class Solution {
    public boolean isValidSerialization(String preorder) {
        int slot=1;//to count the number of slot 
     String[] nodes=preorder.split(",");
     for(String node:nodes){
        // if the String is # then decrese the sloe
        slot--;
        //if any point the slot are goes out of negative then return false
        if(slot < 0)return false;

        if(!node.equals("#")){
            slot+=2;
        } 
     }
     return slot==0;
    }
}
