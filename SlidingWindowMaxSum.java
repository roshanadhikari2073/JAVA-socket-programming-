public class SlidingWindowMaxSum {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0; // sum of current window
        int maxSum = 0; // max sum so far
        int windowStart = 0; // start of the window

        // Iterate through the array and slide the window by one element at a time until the end of the array is reached
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add the current element to the window

            // Check if window size matches 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum); // Update max if needed
                windowSum -= arr[windowStart];        // Remove first element
                windowStart++;                        // Slide window one step
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1};
        int k = 4;
        int maxSum = findMaxSumSubArray(k, arr);
        System.out.println("Maximum sum of a subarray of size " + k + ": " + maxSum);
    }
}
