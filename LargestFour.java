import java.util.*; 
import java.io.*;

/**
 * Question: Have the function LargestFour(arr) take the array of integers stored in arr,
 * and find the four largest elements and return their sum. For example: if arr is [4, 5, -2, 3, 1, 2, 6, 6],
 * then the four largest elements in this array are 6, 6, 4, and 5, and the total sum of these numbers is 21,
 * so your program should return 21. If there are less than four numbers in the array, your program should return
 * the sum of all the numbers in the array.
 * Author: Roshan Adhikari
 */

class Main {

    /**
     * Converts a space-separated string of numbers into an int array and finds the sum
     * of the four largest numbers.
     * @param input The input string from the console.
     * @return The sum of the four largest numbers in the input array.
     */
    public static int LargestFour(String input) {
        // Split the input string into an array of strings, then convert each to an int.
        String[] nums = input.split("\\s+");
        int[] arr = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        // Delegate to the overloaded LargestFour method that handles int arrays.
        return LargestFour(arr);
    }

    /**
     * Finds the sum of the four largest numbers in an array using a PriorityQueue.
     * @param arr The array of integers.
     * @return The sum of the four largest numbers in the array.
     */
    public static int LargestFour(int[] arr) {
        // Initialize sum of the four largest numbers.
        int varOcg = 0; 
        // PriorityQueue to efficiently find the four largest elements.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add each element to the PriorityQueue.
        for (int num : arr) {
            pq.add(num);
        }

        // Extract and sum up the four largest elements.
        for (int i = 0; i < 4 && !pq.isEmpty(); i++) {
            varOcg += pq.poll();
        }

        // Return the sum of the four largest elements.
        return varOcg;
    }

    public static void main(String[] args) {  
        // Create a Scanner object to read input from the console.
        Scanner s = new Scanner(System.in);
        // Read the next line of input and pass it directly to the LargestFour method.
        System.out.print(LargestFour(s.nextLine())); 
        // Close the Scanner.
        s.close();
    }
}
