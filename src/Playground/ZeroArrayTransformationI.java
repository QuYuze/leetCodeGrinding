package Playground;
//https://leetcode.com/problems/zero-array-transformation-i/description/

public class ZeroArrayTransformationI {
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int[] freq = new int[nums.length];
            for(int[] q: queries){
                freq[q[0]]++;
                if(q[1]+1<nums.length){
                    freq[q[1]+1]--;
                }
            }

            int curr = 0;
            for(int i=0; i<nums.length; i++){
                curr += freq[i];
                if(nums[i] >curr){
                    return false;
                }
            }

            return true;
        }
    }
}
