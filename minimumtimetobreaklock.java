import java.util.List;
import java.util.Collections;

class Solution {
    int min = Integer.MAX_VALUE;

    public int findMinimumTime(List<Integer> strength, int k) {
        Collections.sort(strength);
        minOperation(strength, 0, 1, k, 0);
        return min;
    }

    public void minOperation(List<Integer> arr, int currentMask, int currFactor, int k, int time) {
        if (currentMask == (1 << arr.size()) - 1) {
            min = Math.min(min, time);
            return;
        }

        int energy = currFactor, addTime = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((currentMask & (1 << i)) != 0) continue;
            addTime = (arr.get(i) + currFactor - 1) / currFactor;
            minOperation(arr, currentMask | (1 << i), currFactor + k, k, time + addTime);
        }
    }
}

