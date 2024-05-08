package Playground;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    class Solution {
        public int search(int[] nums, int target) {
            int result = -1;
            int low = 0;
            int high = nums.length-1;

            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid]==target){
                    result = mid;
                    break;
                }else{
                    if(nums[low]<=nums[mid]){
                        if(target<nums[mid] && nums[low]<=target){
                            high = mid-1;
                        }else{
                            low = mid+1;
                        }
                    }else{
                        if(target>nums[mid] && nums[high]>=target){
                            low = mid+1;
                        }else{
                            high = mid-1;
                        }
                    }
                }
            }

            return result;
        }
    }
}
