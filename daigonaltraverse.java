class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
             if (mat.length == 0 || mat[0].length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> result = new ArrayList<>();

        // Traverse diagonally
        for (int d = 0; d < m + n - 1; d++) {
            if (d % 2 == 0) { // Even diagonal
                // Start from the top row
                int row = Math.min(d, m - 1);
                int col = d - row;
                while (row >= 0 && col < n) {
                    result.add(mat[row][col]);
                    row--;
                    col++;
                }
            } else { // Odd diagonal
                // Start from the left column
                int col = Math.min(d, n - 1);
                int row = d - col;
                while (col >= 0 && row < m) {
                    result.add(mat[row][col]);
                    row++;
                    col--;
                }
            }
        }

        // Convert List to int array
        int[] diagonalOrder = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            diagonalOrder[i] = result.get(i);
        }
        
        return diagonalOrder;
    }
}