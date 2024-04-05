package Playground;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            backTrack(nums, result, new ArrayList<Integer>(), 0);

            return result;

        }

        private void backTrack(int[] nums, List result, ArrayList temp, int start){
            result.add(new ArrayList<>(temp));

            for(int i=start; i<nums.length; i++){
                temp.add(nums[i]);
                backTrack(nums, result, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
