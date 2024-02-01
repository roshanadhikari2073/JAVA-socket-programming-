import java.util.Arrays;

class Truck {
    int capacity;
    int originalIndex;

    public Truck(int capacity, int originalIndex) {
        this.capacity = capacity;
        this.originalIndex = originalIndex;
    }
}

public class WarehouseDelivery {
    public static int[] getTrucksForItems(int[] trucks, int[] items) {
        Truck[] sortedTrucks = new Truck[trucks.length];
        for (int i = 0; i < trucks.length; i++) {
            sortedTrucks[i] = new Truck(trucks[i], i);
        }

        // Sort trucks based on their capacities
        Arrays.sort(sortedTrucks, (a, b) -> a.capacity - b.capacity);

        // Preprocess to find the minimum index up to each point
        int[] minIndexUpTo = new int[trucks.length];
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < sortedTrucks.length; i++) {
            minIndex = Math.min(minIndex, sortedTrucks[i].originalIndex);
            minIndexUpTo[i] = minIndex;
        }

        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            int item = items[i];
            result[i] = findSuitableTruck(sortedTrucks, minIndexUpTo, item);
        }

        return result;
    }

    private static int findSuitableTruck(Truck[] sortedTrucks, int[] minIndexUpTo, int itemWeight) {
        int left = 0, right = sortedTrucks.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedTrucks[mid].capacity >= itemWeight) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < sortedTrucks.length) {
            return minIndexUpTo[left];
        }
        return -1; // No suitable truck found
    }

    public static void main(String[] args) {
        // Test cases
        int[] trucks = {4, 5, 7, 2};
        int[] items = {1, 2, 5};
        System.out.println(Arrays.toString(getTrucksForItems(trucks, items))); // Expected Output: [0, 1, 2]

        trucks = new int[]{5, 3, 8, 1};
        items = new int[]{6, 10};
        System.out.println(Arrays.toString(getTrucksForItems(trucks, items))); // Expected Output: [3, -1]

        trucks = new int[]{1, 3, 5, 2, 3, 7};
        items = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(getTrucksForItems(trucks, items))); // Expected Output: [3, 1, 2]
    }
}
