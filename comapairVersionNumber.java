class Solution {
    public int compareVersion(String version1, String version2) {
       /* String[] str1=version1.split("\\.");//split them into the String array 
        String [] str2=version2.split("\\.");
        int n1=str1.length;//length of first string 
        int n2=str2.length;//length of 2 nd String
        int p1=0;
        int p2=0;
        while(p1<n1 || p2<n2){// continue traversing untile p1 or p2 not reach to the end of the string
            int num1=(p1<n1)?Integer.parseInt(str1[p1]):0;//convert the string value into the integer else 0
             int num2=(p2<n2)?Integer.parseInt(str2[p2]):0;
             if(num1!=num2){//if the num1 and num2 are not equal 
               return (num1>num2)?1:-1;//if version1 is gretaer then return 1 or else -1 as for given in the question
             }
             p1++;
             p2++;
        }
        return 0;
        */
        // 2nd approach
        int n1=version1.length();
        int n2=version2.length();
        int p1=0;
        int p2=0;
        while(p1<n1 || p2<n2){
            int num1=0;
            while(p1<n1 && version1.charAt(p1)!='.'){// finding the number till the . of version1
                num1=num1*10+(version1.charAt(p1)-'0');
                p1++;
            }
            int num2=0;
            while(p2<n2 && version2.charAt(p2)!='.'){//finding the number till the dot of verion2
                num2=num2*10+ (version2.charAt(p2)-'0');
                p2++;
            }
            if(num1!=num2){//comparing
                return (num1>num2)?1:-1;
            }
            p1++;
            p2++;//for skip the dot
        }
        return 0;

    }
}