// https://leetcode.com/problems/contains-duplicate/
class CheckDupicate {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> uniqueNums = new HashSet<>();

        for(int num: nums) {
            if(uniqueNums.contains(num)) return true;
            uniqueNums.add(num);
        }
        
        return false;
        
    }
}