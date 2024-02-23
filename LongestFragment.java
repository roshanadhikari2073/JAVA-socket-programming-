import java.util.Arrays;

public class LongestFragment {
    public static void main(String[] args) {

        // Test cases with expected outputs in comments
        System.out.println("Test case [23, 333, 33, 30, 0, 505]: Expected output 4, Actual output " + solution(new int[]{23, 333, 33, 30, 0, 505}));
        System.out.println("Test case [615, 88, 498, 99, 9]: Expected output 2, Actual output " + solution(new int[]{615, 88, 498, 99, 9}));
        System.out.println("Test case [123, 456]: Expected output 0, Actual output " + solution(new int[]{123, 456}));
    }

    public static int solution(int[] A) {
        int maxLength = 0;
        
        for (int start = 0; start < A.length; start++) {
            int[] digitCounts = new int[10];
            int uniqueDigits = 0;
            int currentLength = 0;

            for (int end = start; end < A.length; end++) {
                int[] tempDigitCounts = Arrays.copyOf(digitCounts, digitCounts.length);
                int tempUniqueDigits = uniqueDigits;
                for (char digitChar : Integer.toString(A[end]).toCharArray()) {
                    if (tempDigitCounts[digitChar - '0'] == 0) tempUniqueDigits++;
                    tempDigitCounts[digitChar - '0']++;
                }

                if (tempUniqueDigits <= 2) {
                    digitCounts = tempDigitCounts;
                    uniqueDigits = tempUniqueDigits;
                    currentLength++;
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }
}
