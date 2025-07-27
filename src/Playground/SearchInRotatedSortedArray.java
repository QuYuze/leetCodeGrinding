package Playground;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {


    /*
        check if target is in the sorted half
        - if left < mid -> sorted half is left to mid
        - otherwise, sorted half is mid to right

        check if target is in the sorted half or not and move the pointer with respect to the position;

        - if target within left - mid sorted half, then move right to mid, otherwise move left;
        - if target within mid - right sorted half, then move left to mid, otherwise move right;

     */
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length == 1){
                if(nums[0] == target){
                    return 0;
                }else{
                    return -1;
                }
            }
            int result = -1;

            int left = 0;
            int right = nums.length -1;

            while(left <= right){
                int mid = left + (right - left)/2;

                if(nums[mid] == target){
                    return mid;
                }else{
                    if(nums[mid] >= nums[left]){
                        if(target < nums[mid] && target >= nums[left]){
                            right = mid - 1;
                        }else{
                            left = mid + 1;
                        }
                    }else{
                        if(target >= nums[mid] && nums[right] >= target){
                            left = mid + 1;
                        }else{
                            right = mid - 1;
                        }
                    }
                }
            }

            if(nums[left] != target){
                return -1;
            }else{
                return left;
            }
        }
    }
}
