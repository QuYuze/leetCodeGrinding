package Playground;

//https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    class Solution {

        //static int result = 0;

        public int findTargetSumWays(int[] nums, int target) {
            int[] result = {0};
            find(nums, target, 0, 0, result);
            return result[0];
        }

        public void find(int[] nums, int target, int start, int sum, int[] result){
            if(start >= nums.length){
                if(sum == target){
                    result[0]++;
                }
            }else{
                int temp = nums[start];
                find(nums, target, start+1, sum+temp, result);
                find(nums, target, start+1, sum-temp, result);
            }
        }
    }
}
