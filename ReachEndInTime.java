//https://leetcode.com/discuss/interview-question/1482825/linkedin-tech-test-question-reach-the-end-in-time

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachEndInTime {
    public static String reachTheEnd(String[] grid, int maxTime) {
        // The number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length();
    
        // Visited array to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];
    
        // Starting point
        int startX = 0;
        int startY = 0;
    
        // Perform BFS to find the shortest path
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0}); // The third value is the time taken to reach this cell
    
        // Directions in which the pointer can move: down, right, up, left
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
    
            // If the bottom-right corner is reached within maxTime
            if (x == rows - 1 && y == cols - 1 && time <= maxTime) {
                return "Yes";
            }
    
            // Explore all possible movements
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
    
                // Check bounds and if the cell is not blocked and not yet visited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    grid[newX].charAt(newY) == '.' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, time + 1});
                }
            }
        }
    
        // If the bottom-right corner is not reached
        return "No";
    }
    

    public static void main(String[] args) {
        // Example usage
        List<String> grid = List.of(
            "...",
            ".#.",
            "..."
        );
        int maxTime = 5;
        System.out.println(reachTheEnd(grid, maxTime));
    }
}
