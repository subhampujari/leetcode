class Solution {
    public int leastInterval(char[] tasks, int n) {
         // Count the frequency of each task
        HashMap<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }

        // Use a max heap to schedule tasks by their frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(taskCount.values());

        int time = 0;

        while (!maxHeap.isEmpty()) {
            int count = 0; // Number of tasks executed in this interval
            // Temporary list to hold tasks that need to be re-added to the heap
            List<Integer> tempList = new ArrayList<>();

            // Try to schedule tasks for the next n + 1 intervals
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    tempList.add(maxHeap.poll());
                    count++;
                }
            }

            // Add tasks back to the heap if they still have remaining executions
            for (int remaining : tempList) {
                if (remaining > 1) {
                    maxHeap.add(remaining - 1);
                }
            }

            // If we have scheduled tasks, we increment the time, otherwise, we break
            time += !maxHeap.isEmpty() ? n + 1 : count;
        }

        return time;
    }
}