class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int max=0;
        for(int i=-a.length+1;i<a.length;i++){
            for(int j=-a.length+1;j<a.length;j++){
                max=Math.max(max,overlap(a,b,i,j));
            }
        }
        return max;
    }
    public int overlap(int[][] a,int[][] b,int row,int col){
        int count = 0;
    for (int newRow = 0; newRow < a.length; newRow++) {
        for (int newCol = 0; newCol < a.length; newCol++) {
            if ((row + newRow < 0 || newRow + row >= a.length) || 
                (col + newCol < 0 || col + newCol >= a.length)) {
                continue;  // Skip if the shift causes out-of-bounds access
            }
            if (a[newRow][newCol] + b[newRow + row][newCol + col] == 2) {
                count++;  // Increment count if both matrices have 1 at the same position
            }
        }
    }
    return count;
    }
}
