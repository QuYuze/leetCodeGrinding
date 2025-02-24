package Playground;

//https://leetcode.com/problems/sort-colors/

public class sortColors {
    class Solution {
        public void sortColors(int[] nums) {

            if(nums.length == 1){
                return;
            }

            int[] counts = new int[3];

            for(int i=0; i<nums.length; i++){
                counts[nums[i]]++;
            }

            int index = 0;
            for(int i=0; i<counts.length; i++){
                int count = counts[i];

                while(count>0){
                    nums[index] = i;
                    index++;
                    count--;
                }
            }

        }
    }
}
