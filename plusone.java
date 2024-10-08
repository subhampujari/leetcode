class Solution {
    public int[] plusOne(int[] digits) {
        //simple i can use for loop doing the things
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;//if the digit is less than the 9 then add the 1 and return 
                return digits;
            }
            digits[i]=0;//if is  equal 9 then add it 0 and increse the previsou number 1
        }
        int []newDigit=new int[n+1];
        newDigit[0]=1;//this is per ceratain condation like 9,99,999
        return newDigit;
}
}