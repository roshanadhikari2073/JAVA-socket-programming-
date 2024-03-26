// Kadane Algorithm

import java.util.Collections;
import java.util.List;

public class MaxSumArray {

    public static long reachTheEnd(List<Integer> path, int maxStep) {
        int n = path.size();
        long[] dp = new long[n];
        
        // Initialize the first position with the first value from the path.
        dp[0] = path.get(0);

        // Fill dp array with minimum values as we will be using max function later.
        for (int i = 1; i < n; i++) {
            dp[i] = Long.MIN_VALUE;
        }
        
        // Apply modified Kadane's algorithm
        for (int i = 1; i < n; i++) {
            // Look back up to 'maxStep' positions to find the best previous step.
            for (int j = Math.max(0, i - maxStep); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + path.get(i));
            }
        }

        // The last position of dp array contains the maximum sum that can be reached.
        return dp[n - 1];
    }

    public static void main(String[] args) {
        List<Integer> path = List.of(5, 100, -70, -90, -80, 100); // Example path
        int maxStep = 3; // Example max steps
        System.out.println(reachTheEnd(path, maxStep)); // Expected output is 130
    }
}
