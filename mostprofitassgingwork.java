class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       int n = difficulty.length;
        int m = worker.length;

        // Step 1: Sort the jobs based on difficulty.
        // Create a 2D array where each job has a (difficulty, profit) pair.
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs based on difficulty.
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Sort workers by their ability.
        Arrays.sort(worker);

        int totalProfit = 0;
        int jobIndex = 0;
        int maxProfit = 0;

        // Step 3: Assign workers to the most profitable jobs they can handle.
        for (int i = 0; i < m; i++) {
            // While there are jobs that the current worker can do
            // (i.e., worker[i] >= difficulty of the job),
            // update the max profit the worker can get.
            while (jobIndex < n && worker[i] >= jobs[jobIndex][0]) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            
            // Add the max profit the worker can get
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}