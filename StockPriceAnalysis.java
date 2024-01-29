// A team of analysts at Amazon needs to analyze the stock prices of Amazon over a period of several months.
// A group of consecutively chosen months is said to be maximum profitable if the price in its first or last month is the maximum for the group. More formally, a group of consecutive months [L, ..., R] is said to be maximum profitable if either:
// stockPrice[L] = max(stockPrice[L], stockPrice[L + 1], ..., stockPrice[R])
// stockPrice[R] = max(stockPrice[L], stockPrice[L + 1], ..., stockPrice[R])
// Given prices over n consecutive months, find the number of maximum profitable groups which can be formed. Note that the months chosen must be consecutive, i.e., you must choose a subarray of the given array.

// Author: Roshan Adhikari

import java.util.Stack;

public class StockPriceAnalysis {
    public static long countMaximumProfitableGroups(int[] stockPrice) {
        int n = stockPrice.length;
        int[] ngl = new int[n]; // Nearest Greater to Left
        int[] ngr = new int[n]; // Nearest Greater to Right
        Stack<Integer> stack = new Stack<>();

        // Initialize NGL with -1 (indicating no greater element to the left)
        for (int i = 0; i < n; i++) {
            ngl[i] = -1;
        }

        // Calculate NGL
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stockPrice[stack.peek()] <= stockPrice[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ngl[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        // Initialize NGR with n (indicating no greater element to the right)
        for (int i = 0; i < n; i++) {
            ngr[i] = n;
        }

        // Calculate NGR
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stockPrice[stack.peek()] < stockPrice[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ngr[i] = stack.peek();
            }
            stack.push(i);
        }

        // Counting maximum profitable groups
        long count = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = (i - (ngl[i] == -1 ? -1 : ngl[i]));
            long rightCount = ((ngr[i] == n ? n : ngr[i]) - i);
            count += leftCount * rightCount - 1; // Subtract 1 to exclude the subarray where it's neither first nor last
        }

        return count;
    }

    public static void main(String[] args) {
        int[] stockPrice = {3,1,3,5};
        System.out.println("Maximum Profitable Groups: " + countMaximumProfitableGroups(stockPrice));
    }
}
