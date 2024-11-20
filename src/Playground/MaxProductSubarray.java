package Playground;

public class MaxProductSubarray {

//    https://leetcode.com/problems/maximum-product-subarray/solutions/1608862/java-3-solutions-detailed-explanation-using-image/

    class Solution {
        public int maxProduct(int[] nums) {
            int result = nums[0];

            int max = nums[0];

            int min = nums[0];

            for(int i=1; i<nums.length; i++){
                int temp = max;
                max = Math.max(Math.max(min * nums[i], nums[i]*max), nums[i]);
                min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);

                if(max > result){
                    result = max;
                }
            }


            return result;

        }
    }
}
