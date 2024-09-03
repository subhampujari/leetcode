class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0)return "";
        String [] st=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            st[i]=Integer.toString(nums[i]);
        }
     Arrays.sort(st,new Comparator<String>(){
        public int compare(String a,String b){
            String o1=a+b;
            String o2=b+a;
            return o2.compareTo(o1);
        }
     });
     if(st[0].equals("0"))return "0";
     StringBuilder sb=new StringBuilder();
     for(String s:st){
        sb.append(s);
     }
     return sb.toString();
    }
}