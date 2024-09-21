class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
    List<String> res=new ArrayList<>();
    for(int i=0;i<12;i++){//it should for the hour
        for(int j=0;j<60;j++){//it should for the miniut
       int totalbit=Integer.bitCount(i)+Integer.bitCount(j);

       //if the totalbit and turned bit are equal then addinto the list
       if(totalbit==turnedOn){
        String time=i + ":" + String.format("%02d",j);
        res.add(time);
        
       }
        }
    }   
    return res;
    }
}