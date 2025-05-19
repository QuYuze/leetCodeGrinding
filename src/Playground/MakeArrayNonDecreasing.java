package Playground;

//https://leetcode.com/problems/make-array-non-decreasing/

public class MakeArrayNonDecreasing {
    class Solution {
        public int maximumPossibleSize(int[] nums) {

            int result = 0;
            if(nums.length == 1){
                return 1;
            }
            int pre = -1;
            for(int n: nums){
                if(n >= pre){
                    result++;
                    pre = n;
                }

            }

            return result;
        }
    }
}
