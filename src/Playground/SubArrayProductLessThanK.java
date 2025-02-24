package Playground;

//https://leetcode.com/problems/subarray-product-less-than-k/

public class SubArrayProductLessThanK {

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int result = 0;
            int left = 0;
            int right = 0;
            int product = 1;
            int count = 0;

            if(k<=1){
                return result;
            }

            while(right<nums.length){
                product *= nums[right];
                while(product>=k){
                    product /= nums[left];
                    left++;
                }

                count += 1 + (right - left);
                right++;

            }

            result = count;

            return result;
        }
    }
}
