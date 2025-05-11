package Playground;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/6720092/100-easy-solutions-c-java-c-python-python3/
public class RemoveDuplicatesInSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int result = 0;

            for(int j=1; j<nums.length; j++){
                if(nums[j]!=nums[result]){
                    result++;
                    nums[result] = nums[j];
                }
            }

            result++;

            return result;
        }
    }
}
