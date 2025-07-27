package Playground;

public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                if (nums[0] == val) {
                    return 0;
                } else {
                    return 1;
                }
            }

            int right = nums.length - 1;
            int left = 0;

            while (left < right) {

                while (left < nums.length && nums[left] != val) {
                    left++;
                }

                while (right >= 0 && nums[right] == val) {
                    right--;
                }

                if (left < right) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
                //System.out.println(Arrays.toString(nums));
            }

            int result = 0;

            while(result < nums.length && nums[result] != val){
                result++;
            }

            return result;

        }
    }

}
