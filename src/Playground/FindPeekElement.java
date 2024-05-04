package Playground;
//https://leetcode.com/problems/find-peak-element/description/
public class FindPeekElement {

    class Solution {
        public int findPeakElement(int[] nums) {

            int result = 0;
            int low = 0;
            int high = nums.length-1;

            if(nums.length==1){
                return 0;
            }else if(nums[nums.length-2]<nums[nums.length-1]){
                return nums.length-1;
            }else if(nums[1]<nums[0]){
                return 0;
            }

            while(low<high){
                int mid = low + (high-low)/2;
                System.out.println(mid);

                if(nums[mid+1]<nums[mid] && nums[mid-1]<nums[mid]){
                    result = mid;
                    break;

                }

                if(nums[mid-1]>nums[mid]){
                    high = mid;
                }else if(nums[mid+1]>nums[mid]){
                    low = mid;
                }

            }



            return result;
        }
    }
}
