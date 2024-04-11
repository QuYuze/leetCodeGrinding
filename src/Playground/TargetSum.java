package Playground;

//https://leetcode.com/problems/target-sum/description/
public class TargetSum {

    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            int result = 0;
            result = find(nums, target, 0, 0);
            return result;
        }

        public int find(int[] nums, int target, int start, int sum){
            if(start >= nums.length){
                if(sum == target){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                int temp = nums[start];
                int left = find(nums, target, start+1, sum+temp);
                int right = find(nums, target, start+1, sum-temp);
                return left+right;
            }
        }
    }
}
