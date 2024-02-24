import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MRoom {
    public static int solution(int n, int[][] meetings){
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> availableRooms = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
        );
        int[] meetingCounts = new int[n];

        for(int i = 0; i<n; i++){

        }
        return 0;
    }
}
