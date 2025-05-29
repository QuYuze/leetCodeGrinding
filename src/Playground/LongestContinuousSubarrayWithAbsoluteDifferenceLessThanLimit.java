package Playground;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solutions/5354709/98-54-easy-solution-with-explanation/

public class LongestContinuousSubarrayWithAbsoluteDifferenceLessThanLimit {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            if(nums.length == 1){
                return 1;
            }

            int result = 0;
            int left = 0;
            Deque<Integer> increase = new LinkedList<>();
            Deque<Integer> decrease = new LinkedList<>();

            for(int right=0; right<nums.length; right++){
                int curr = nums[right];
                while(!increase.isEmpty() && increase.peekLast() > curr){
                    increase.removeLast();
                }
                increase.addLast(curr);

                while(!decrease.isEmpty() && decrease.peekLast() <  curr){
                    decrease.removeLast();
                }
                decrease.addLast(curr);

                while(decrease.peekFirst()-increase.peekFirst() > limit){
                    int leftNum = nums[left];
                    if(decrease.peekFirst() == leftNum){
                        decrease.removeFirst();
                    }
                    if(increase.peekFirst() == leftNum){
                        increase.removeFirst();
                    }
                    left++;
                }

                int length = right - left + 1;
                result = result < length ? length : result;
            }

            return result;
        }
    }
}
