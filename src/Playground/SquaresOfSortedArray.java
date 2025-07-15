package Playground;

public class SquaresOfSortedArray {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];

            if(nums.length == 1){
                result[0] = nums[0] * nums[0];
                return result;
            }

            int left = 0;
            int right = nums.length - 1;
            int i = result.length - 1;

            while(left <= right && i >= 0){
                int curr = 0;
                if(Math.abs(nums[left]) > Math.abs(nums[right])){
                    curr = nums[left] * nums[left];
                    left++;
                }else{
                    curr = nums[right] * nums[right];
                    right--;
                }
                result[i] = curr;
                i--;
            }

            return result;
        }
    }
}
