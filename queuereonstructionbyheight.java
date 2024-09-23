import java.io.*;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // we can solve this question using the compartor with O(N logN)
        List<int[]> res=new ArrayList();
        //sorting the people array with as compared to the k 
        Arrays.sort(people,(a,b)->{
            return (a[0]==b[0] ? a[1]-b[1] :b[0]-a[0]);
        });

        //treversing the peope array to return the result
        for(int []x:people){
            res.add(x[1],x);
        }
        return res.toArray(new int[people.length][2]);
    }
}
