class Solution {
    public int countSegments(String s) {
      int count=0;
      boolean flage=false;

      for(int i=0;i<s.length();i++){
        if(s.charAt(i)!=' '){
            if(!flage){
                count++;
                flage=true;
            }
        }else{
            flage=false;
        }
      }
      return count;
    }
}