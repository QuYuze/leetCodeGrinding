package Playground;

public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if(nums.length == 1 && nums[0] > 1){
                return 1;
            }

            for(int i=0; i<nums.length; i++){
                int curr = nums[i];
                while(curr-1 >= 0 && curr-1 < nums.length && curr-1!=i && curr != nums[curr-1]){
                    swap(nums, curr-1, i);
                    curr = nums[i];
                }
            }

            for(int i=0; i<nums.length; i++){
                if(nums[i] != i+1){
                    return i+1;
                }
            }

            return nums[nums.length-1]+1;


        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
