package Playground;

//https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/627921/java-c-python3-easy-explanation-o-logn-o-1/
public class SingleElementInSortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            int mid = 0;

            if(nums.length==1){
                return nums[0];
            }

            while(left < right){
                mid = left + (right - left)/2;

                if((mid%2==0 && nums[mid+1]==nums[mid]) || (mid%2==1 && nums[mid-1]==nums[mid])){
                    left = mid+1;
                }else{
                    right = mid;
                }

            }
            return nums[left];
        }
    }
}
