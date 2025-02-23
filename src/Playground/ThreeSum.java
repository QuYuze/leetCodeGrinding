package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            HashSet<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);

            for(int i=0; i<nums.length; i++){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum<0){
                        j++;
                    }else if(sum>0){
                        k--;
                    }else if(sum==0){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }

            result.addAll(set);

            return result;
        }
    }
}
