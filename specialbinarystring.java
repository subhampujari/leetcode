class Solution {
    public String makeLargestSpecial(String s) {
         List<String> res=new ArrayList<>();
         int countOne=0;
         int countZero=0;
         int lastIndex=0;

         for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                countOne++;
            }else{
                countZero++;
            }

            if(countOne==countZero){
                StringBuilder sb=new StringBuilder();
                String str="1"+makeLargestSpecial(s.substring(lastIndex+1,i))+"0";
                res.add(str);
                lastIndex=i+1;
            }
         }
     Collections.sort(res, Collections.reverseOrder());
    StringBuilder ans=new StringBuilder();
    for (String substring : res) {
            ans.append(substring);
        }

        return ans.toString();

    }
}
