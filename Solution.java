public class Solution extends GuessGame {
    public int guessNumber(int n) {
          int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent overflow

            int result = guess(mid);

            if (result == 0) {
                return mid; // The picked number is `mid`
            } else if (result == -1) {
                right = mid - 1; // The picked number is smaller than `mid`
            } else {
                left = mid + 1; // The picked number is larger than `mid`
            }
        }

        // The picked number should be found within the range, so this line should never be reached.
        throw new IllegalStateException("The picked number is not within the range [1, " + n + "].");
    }
}