import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoomsWithMostMeetings {

    public int RoomsWithMostMeetings(int n, int[][] meetings){
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0])); // sort by start time
        PriorityQueue<int[]> roomAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // sort by end time
        int[] meetingCounts = new int[n];

        for(int i = 0; i < n; i++){
            roomAvailable.add(new int[]{i,0});
        }

        for(int[] meeting: meetings) {
            while(!roomAvailable.isEmpty() && roomAvailable.peek()[1] <= meeting[0]){
                int[] room = roomAvailable.poll();
                if(meetingCounts[room[0]] > 1){
                    room[1] = room[1]
                } else {
                    room[1] = meeting[1];
                }
                meetingCounts[room[0]]++;
            }
        }

        int maxMeetings = 0, roomsWithMostMeetings = -1;

        for( int i =0; i < n; i++){
            if(meetingCounts[i] > maxMeetings){
                maxMeetings = meetingCounts[i];
                roomsWithMostMeetings = i;
            }
        }



        return roomsWithMostMeetings;
    }

}
