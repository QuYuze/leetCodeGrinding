package Playground;

//https://leetcode.com/problems/minimum-size-subarray-sum/

public class MinimumSizeOfSubArraySum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = nums.length+1;

            if(nums.length == 1){
                if(target <= nums[0]){
                    return 1;
                }else{
                    return 0;
                }

            }

            int left = 0;
            int currSum = 0;

            for(int right = 0; right<nums.length; right++){
                currSum += nums[right];

                while(currSum >= target){
                    int currLength = right - left + 1;
                    if(currLength < result){
                        result = currLength;
                    }
                    currSum -= nums[left];
                    left++;
                }
            }

            return result != nums.length+1 ? result : 0;
        }
    }
}
