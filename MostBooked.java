import java.util.Arrays;
import java.util.PriorityQueue;

// leet code hard problem
// question: https://leetcode.com/discuss/interview-question/421787/
// question in another: https://leetcode.com/discuss/interview-question/421787/Amazon-or-OA-2019-or-Most-Booked-Room
// solution: https://leetcode.com/problems/meeting-rooms-ii/


// real one https://leetcode.com/problems/meeting-rooms-iii/?envType=daily-question&envId=2024-02-17


class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by their start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Priority Queue for tracking idle room indices
        PriorityQueue<Integer> idleRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            idleRooms.offer(i);
        }

        // Priority Queue for tracking busy rooms by their availability time, then room index
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Array to count bookings for each room
        int[] bookingCounts = new int[n];

        for (int[] meeting : meetings) {
            // Free up rooms that have become available
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= meeting[0]) {
                idleRooms.offer(busyRooms.poll()[1]);
            }

            if (!idleRooms.isEmpty()) {
                int roomId = idleRooms.poll();
                bookingCounts[roomId]++;
                busyRooms.offer(new int[]{meeting[1], roomId});
            } else {
                int[] busyRoom = busyRooms.poll();
                bookingCounts[busyRoom[1]]++;
                // Extend the busy room's booking time
                busyRoom[0] += meeting[1] - meeting[0];
                busyRooms.offer(busyRoom);
            }
        }

        // Determine the most booked room
        int maxBooked = 0;
        for (int i = 1; i < n; i++) {
            if (bookingCounts[i] > bookingCounts[maxBooked]) {
                maxBooked = i;
            }
        }

        return maxBooked;
    }
}
