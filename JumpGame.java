// https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int leftMax = n - 1; 
        
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMax) {
                leftMax = i;
            }
        }
        
        return leftMax == 0;
    }
}
