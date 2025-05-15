package Playground;

//https://leetcode.com/problems/next-permutation/solutions/6500850/video-don-t-worry-if-you-can-t-solve-this-question/

public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i =  nums.length-1;

            while(i > 0 && nums[i-1] >= nums[i]){
                i--;
            }

            if(i==0){
                reverse(0, nums.length-1, nums);
                return;
            }

            int j = nums.length-1;

            while(j >= i && nums[j] <= nums[i-1]){
                j--;
            }

            swap(i-1, j, nums);
            reverse(i, nums.length-1, nums);

        }

        private void swap(int i, int j, int[] nums){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int i, int j, int[] nums){
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }


    }
}
