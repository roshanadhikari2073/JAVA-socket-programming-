import java.util.PriorityQueue;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length ; i ++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                if (ladders > pq.size()){
                    pq.offer(diff);
                } else {
                    int br = diff;
                    if (!pq.isEmpty() && diff > pq.peek()) {
                        br = pq.remove();
                        pq.offer(diff);
                    }
                    if (bricks - br >= 0) {
                        bricks -= br;
                    } else {
                        return i - 1;
                    }
                }

            }
        }

        return heights.length - 1;

    }
}


