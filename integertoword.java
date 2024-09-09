class Solution {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",  "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
         if(num==0)return "Zero";
       String word="";
       int  i=0;
       while(num > 0){
        if(num % 1000!=0){
            word=helper(num % 1000)+THOUSANDS[i]+" "+word;
       }
       num/=1000;
       i++;
       }
       return word.trim();
    }
    public String helper(int num){
        if(num==0)return "";//base case
        if(num < 20){// if the number is less than 20 then directly call the string arraay index 
            return LESS_THAN_20[num]+" ";
        }else if(num < 100){
            return TENS[num/10]+" "+helper(num%10);
        }else
            return LESS_THAN_20[num/100]+" Hundred "+helper(num%100);      
    }
}