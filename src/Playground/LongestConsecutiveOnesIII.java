package Playground;
//https://leetcode.com/problems/max-consecutive-ones-iii/
public class LongestConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int result = 0;
            int left = 0;
            int zeroes = 0;

            for(int right=0; right<nums.length; right++){

                int curr = nums[right];

                if(curr == 0){
                    if(zeroes < k){
                        zeroes++;
                    }else if(k==0){
                        left = right + 1;
                    }else{

                        while(nums[left]!=0){
                            left++;
                        }
                        if(left < right){
                            left++;
                        }

                    }

                }

                int length = right - left + 1;
                result = result < length ? length : result;
            }


            return result;
        }
    }
}
