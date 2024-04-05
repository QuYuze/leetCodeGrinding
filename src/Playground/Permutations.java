package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
//use backtrack for all permuation and subset problems
public class Permutations {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backTrack(nums, new ArrayList<Integer>(), result);

            return result;
        }

        private void backTrack(int[] nums, ArrayList temp, List<List<Integer>> result){
            if(temp.size()==nums.length){
                result.add(new ArrayList<>(temp));
            }else{
                for(int i=0; i<nums.length; i++){
                    if(!temp.contains(nums[i])){
                        temp.add(nums[i]);
                        backTrack(nums, temp, result);
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }
    }
}
