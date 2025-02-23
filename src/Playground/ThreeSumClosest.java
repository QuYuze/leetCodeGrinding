package Playground;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int result = 0;
            int diff = 100000*nums.length;

            Arrays.sort(nums);

            for(int i=0; i<nums.length; i++){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    int sum = nums[i] + nums[j] + nums[k];
                    int currDiff = Math.abs(sum - target);
                    if(sum < target){
                        j++;
                    }else if(sum > target){
                        k--;
                    }else{
                        return target;
                    }
                    if(diff >= currDiff){
                        diff = currDiff;
                        result = sum;
                    }
                }
            }

            return result;
        }
    }
}
