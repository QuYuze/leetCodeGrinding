package Playground;

//https://leetcode.com/problems/find-pivot-index/

public class FindPivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int result = -1;

            if(nums.length == 1){
                return 0;
            }

            int[] leftSum = new int[nums.length];
            int[] rightSum = new int[nums.length];

            for(int i=1; i<nums.length; i++){
                leftSum[i] = leftSum[i-1] + nums[i-1];
            }

            for(int i=nums.length-2; i>=0; i--){
                rightSum[i] = rightSum[i+1] + nums[i+1];
            }

            //System.out.println(Arrays.toString(leftSum));
            //System.out.println(Arrays.toString(rightSum));

            for(int i=0; i<nums.length; i++){
                if(leftSum[i] == rightSum[i]){
                    return i;
                }
            }

            return result;

        }
    }
}
