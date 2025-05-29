package Playground;

//https://leetcode.com/problems/rotate-array/solutions/4803557/beats-100-00-of-users-with-java-simple-easy-array-swap-two-pointer-approach
public class rotateArray {

    public class Solution1 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length; //prevent k greater than length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);

        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }

    class Solution2 {
        public void rotate(int[] nums, int k) {

            int realK = k%nums.length;
            if(realK==0){
                return;
            }else{
                int[] tail = new int[realK];
                int j = 0;

                for(int i=nums.length-realK; i<nums.length; i++){
                    tail[j] = nums[i];
                    j++;
                }

                for(int i=nums.length-1; i>=realK; i--){
                    nums[i] = nums[i-realK];
                }

                for(int i=0; i<realK; i++){
                    nums[i] = tail[i];
                }
            }

        }
    }

}
