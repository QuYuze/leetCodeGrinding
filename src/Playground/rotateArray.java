package Playground;

//https://leetcode.com/problems/rotate-array/solutions/4803557/beats-100-00-of-users-with-java-simple-easy-array-swap-two-pointer-approach
public class rotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length; //prevent k greater than length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
