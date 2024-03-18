// https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150

class TrappedWater {
    public int trap(int[] height) {

        //using two pointer left and right to resolve the problem
        int left = 0;
        int right = height.length - 1; 

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while(left < right) {

            if(height[left] < height[right]) {
                // this will check in case of the equal height
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                } 
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            } 
        }

        return totalWater;


    }
}