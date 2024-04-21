package Playground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//https://leetcode.com/problems/permutations-ii/description/
public class PermutationII {

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();

            backtrack(nums, result, new ArrayList(), new HashSet());

            return result;
        }

        private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, HashSet<Integer> set){
            if(temp.size()==nums.length){
                if(!result.contains(temp)){
                    result.add(new ArrayList(temp));
                }

            }else{
                for(int i=0; i<nums.length; i++){
                    if(!set.contains(i)){
                        set.add(i);
                        temp.add(nums[i]);
                        backtrack(nums, result, temp, set);
                        temp.remove(temp.size()-1);
                        set.remove(i);
                    }
                }

            }

        }
    }
}
