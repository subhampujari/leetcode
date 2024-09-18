import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class Pair {
        int u;
        int v;
        int index;

        Pair(int u, int v, int index) {
            this.u = u;
            this.v = v;
            this.index = index;
        }

        public int sum() {
            return u + v;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Base case for nums1 and nums2
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return res;
        }

        // Priority queue
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.sum() - b.sum());
        
        // Adding the elements into the queue
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            q.add(new Pair(nums1[i], nums2[0], 0));
        }

        // Finding the k smallest pairs
        while (k > 0 && !q.isEmpty()) {
            Pair current = q.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(current.u);
            pair.add(current.v);
            res.add(pair);
            k--;

            // Adding the next pair of the array of both
            if (current.index + 1 < nums2.length) {
                q.offer(new Pair(current.u, nums2[current.index + 1], current.index + 1));
            }
        }
        
        return res;
    }
}
