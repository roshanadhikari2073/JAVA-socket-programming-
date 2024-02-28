// Boyer-Moore Voting Algorithm Explained

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

//    public int majorityHashMap(int[] nums) {
//        Map<Integer, Integer> maps = new HashMap<>();
//
//    }
}

// can also use hashMap to store the value


// nums = [4, 7, 4, 7, 7, 4, 7, 9, 4, 7, 7, 4, 7]