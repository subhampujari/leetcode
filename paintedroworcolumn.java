class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> numPos = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        // Initialize the position maps
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                numPos.put(mat[i][j], new int[] {i, j});
            }
        }

        // Arrays to count numbers in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Process each number in arr
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = numPos.get(num);
            int row = pos[0];
            int col = pos[1];

            // Increment row and column counts
            rowCount[row]++;
            colCount[col]++;

            // Check if any row or column is complete
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        return -1;
    }
}
