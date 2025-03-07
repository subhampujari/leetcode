class Solution {
    public double largestTriangleArea(int[][] points) {
            int n = points.length;
        double maxArea = 0.0;
        
        // Iterate through all combinations of three points
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate the area of the triangle formed by points[i], points[j], and points[k]
                    double area = areaOfTriangle(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    // Helper method to calculate the area of the triangle formed by three points
    private double areaOfTriangle(int[] p1, int[] p2, int[] p3) {
        return 0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
    }
}
