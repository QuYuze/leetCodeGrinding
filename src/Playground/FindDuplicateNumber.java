package Playground;

import java.util.HashSet;


//https://leetcode.com/problems/find-the-duplicate-number/
//https://leetcode.com/problems/find-the-duplicate-number/solutions/6097957/video-floyd-s-tortoise-and-hare-algorithm-and-prove-it-with-simple-calculation/
public class FindDuplicateNumber {

    class Solution {
        public int findDuplicate(int[] nums) {

            int result = 0;
            int slow = nums[0];
            int fast = nums[0];

            while(true){
                slow = nums[slow];
                fast = nums[nums[fast]];

                if(slow == fast)
                    break;
            }

            int slow2 = nums[0];

            while(slow2!=slow){
                slow = nums[slow];
                slow2 = nums[slow2];
            }

            result = slow;

            return slow;

        }
    }
}
