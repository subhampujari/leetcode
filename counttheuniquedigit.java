class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //base case if n== 0 then retun 1
        if(n==0)return 1;
        //if n is 1 then retuirn 10
        if(n>10)n=10;//we have only 0-9 digit 

        int count=0;
        for(int i=1;i<=n;i++){
            count+=countNumber(i);
        }
        return count;
    }
    public int countNumber(int length){
        if(length==1)return 10;

        int count=9;
        int availabecount=9;
        for(int i=1;i<length;i++){
            count*=availabecount;
            availabecount--;
        }
        return count;
    }
}
