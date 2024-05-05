package Playground;


//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
public class FindMininumInRotatedSortedArray {

    class Solution {
        public int findMin(int[] nums) {

            int result = 0;
            int low = 0;
            int high = nums.length-1;

            if(nums.length == 1){
                return nums[0];
            }else if(nums[nums.length-1]>nums[0]){
                return nums[0];
            }


            while(low <= high){
                int mid = low + (high-low)/2;

                if(nums[mid+1] < nums[mid]){
                    result = nums[mid+1];
                    break;
                }else{
                    if(mid > 0){
                        if(nums[mid-1] > nums[mid]){
                            result = nums[mid];
                            break;
                        }
                    }

                    if(nums[high] < nums[mid]){
                        low = mid+1;
                    }else if(nums[high] > nums[mid]){
                        high = mid-1;
                    }
                }
            }

            return result;
        }
    }
}
