package Playground;

import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {

            int result = 0;
            if(nums.length == 0){
                return result;
            }

            HashSet<Integer> set = new HashSet<>();

            for(int n : nums){
                set.add(n);
            }

            int maxLength = 0;
            int currLength = 1;

            for(int n : set){
                int curr = n;

                if(!set.contains(curr-1)){

                    while(set.contains(curr+1)){
                        currLength++;
                        curr++;
                    }

                    if(currLength > maxLength){
                        maxLength = currLength;
                    }

                    currLength = 1;
                }


            }

            result = maxLength;

            return result;
        }
    }
}
