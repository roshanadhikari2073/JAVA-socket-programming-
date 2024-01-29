// Q: The task is to determine the number of subarrays (consecutive groups of months) where either the first or last element is the maximum value in that subarray. This represents a "maximum profitable group" in the context of stock prices over a series of months.
// Author : Roshan Adhikari
public class CalculateMaximumProfit {
    public static long countMaximumProfitableGroups(int[] stockPrice) {
        int n = stockPrice.length;
        long count = 0;
    
        // For each element as a starting point
        for (int start = 0; start < n; start++) {
            int maxSoFar = stockPrice[start];
            // Extend to the right
            for (int end = start; end < n; end++) {
                if (stockPrice[end] > maxSoFar) {
                    maxSoFar = stockPrice[end];
                }
                // Check if the start or end is the maximum
                if (stockPrice[start] == maxSoFar || stockPrice[end] == maxSoFar) {
                    count++;
                }
            }
        }
    
        return count;
    }
    
    public static void main(String[] args) {
        int[] stockPrice1 = {3, 1, 3, 5};
        System.out.println("Number of Maximum Profitable Groups (3,1,3,5): " + countMaximumProfitableGroups(stockPrice1));
    
        int[] stockPrice2 = {1, 5, 2};
        System.out.println("Number of Maximum Profitable Groups (1,5,2): " + countMaximumProfitableGroups(stockPrice2));
    }
    
    
}
