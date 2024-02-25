import java.util.List;

public class DistinctDigitCounter {

    private static boolean hasDistinctDigits(int number) {
        int digitChecker = 0;
        while (number > 0) {
            int digit = number % 10;
            if ((digitChecker & (1 << digit)) > 0) {
                return false; // Digit already seen, not distinct
            }
            digitChecker |= (1 << digit); // Mark the digit as seen
            number /= 10;
        }
        return true;
    }

    public static void countDistinctDigitNumbers(List<List<Integer>> ranges) {
        for (List<Integer> range : ranges) {
            int start = range.get(0);
            int end = range.get(1);
            int count = 0;

            for (int i = start; i <= end; i++) {
                if (hasDistinctDigits(i)) {
                    count++;
                }
            }

            System.out.println("Range [" + start + ", " + end + "]: " + count);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(
                List.of(1, 20),
                List.of(9, 19),
                List.of(1, 100),
                List.of(90, 123)
        );

        countDistinctDigitNumbers(arr);
    }
}
