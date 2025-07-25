package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();

            if(nums.length < 4){
                return result;
            }

            Arrays.sort(nums);

            for(int i=0; i<nums.length-3; i++){
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }else{
                    for(int j=i+1; j<nums.length-2; j++){
                        if(j>i+1 && nums[j]==nums[j-1]){
                            continue;
                        }
                        int left = j+1;
                        int right = nums.length-1;
                        while(left < right){
                            long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                            if(sum == target){
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                                while(left<right && nums[left+1] == nums[left]){
                                    left++;
                                }
                                left++;
                                while(right>left && nums[right-1] == nums[right]){
                                    right--;
                                }
                                right--;
                            }else if(sum < target){
                                left++;
                            }else{
                                right--;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
}
