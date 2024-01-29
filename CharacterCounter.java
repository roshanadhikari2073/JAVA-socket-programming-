/**
 * This class contains a method to determine the beauty of a string based on character frequency.
 * A string is considered "beautiful" if no letter in the string appears more times than the
 * previous letter in the alphabet. The problem was provided by Roshan Adhikari.
 * 
 * Author: Roshan Adhikari
 */
public class CharacterCounter {

    /**
     * Checks if the input string is "beautiful".
     * A string is "beautiful" if no letter appears more times than the previous letter in the alphabet.
     *
     * @param inputString The string to check.
     * @return true if the string is beautiful, false otherwise.
     */
    public static boolean isBeautiful(String inputString) {
        // Array to store the frequency of each character.
        int[] freq = new int[26]; // Since there are 26 lowercase letters.

        // Count the frequency of each character in the string.
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            freq[currentChar - 'a']++;
        }

        // Check if any character appears more times than its previous character.
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > freq[i - 1]) {
                return false;
            }
        }

        // If the loop completes without returning false, the string is beautiful.
        return true;
    }

    public static void main(String[] args) {
        // Example test cases
        System.out.println(isBeautiful("bbaacdafe")); // Expected: true
        System.out.println(isBeautiful("aabbb"));     // Expected: false
        System.out.println(isBeautiful("bbc"));       // Expected: false
    }
}
