package Playground;
//https://leetcode.com/problems/jump-game/
public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            boolean result = false;

            if(nums[0] >= nums.length || nums.length == 1){
                return true;
            }

            int currIndex = nums.length-1;
            int currReq = 1;
            int prev = currIndex - 1;

            while(prev > -1){

                if(nums[prev] >= currReq){
                    result = true;
                    currIndex = prev;
                    prev--;
                    currReq = 1;
                }else{
                    result = false;
                    prev--;
                    currReq++;
                }
            }

            return result;
        }
    }
}
