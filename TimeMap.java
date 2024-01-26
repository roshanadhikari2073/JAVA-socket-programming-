// Q: Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
// Author : Roshan Adhikari

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> list = map.get(key);
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).first <= timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return "";
        }
        return list.get(high).second;
    }

    private static class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // The set operation doesn't return anything.
        System.out.println(timeMap.get("foo", 1));  // Should print "bar".
        System.out.println(timeMap.get("foo", 3));  // Should print "bar" as it's the latest value before timestamp 3.
        timeMap.set("foo", "bar2", 4);  // Again, set doesn't return anything.
        System.out.println(timeMap.get("foo", 4));  // Should print "bar2".
        System.out.println(timeMap.get("foo", 5));  // Should print "bar2" as it's the latest value before timestamp 5.
    }
}
