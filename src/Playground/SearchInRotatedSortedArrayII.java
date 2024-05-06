package Playground;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/3888242/100-binary-search-video-with-rotation-handling-optimal/
public class SearchInRotatedSortedArrayII {

    class Solution {
        public boolean search(int[] nums, int target) {

            boolean result = false;

            int low = 0;
            int high = nums.length-1;

            while(low <= high){
                int mid = low + (high - low)/2;

                if(nums[mid]==target){
                    return true;
                }else if(nums[low]==nums[mid]){
                    low++;
                }else{
                    if(nums[low]<nums[mid]){
                        if(target<nums[mid] && nums[low]<=target){
                            high = mid-1;
                        }else{
                            low=mid+1;
                        }

                    }else{
                        if(target>nums[mid] && target<=nums[high]){
                            low = mid+1;
                        }else{
                            high=mid-1;
                        }
                    }
                }
            }


            return result;
        }
    }
}
