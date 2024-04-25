package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backTrack(result, candidates, target, 0, 0, new ArrayList(), -1);

            return result;
        }

        public void backTrack(List<List<Integer>> result, int[] candidates, int target, int start, int sum, ArrayList<Integer> temp, int pre){
            if(sum > target){
                return;
            }else if(sum == target){
                result.add(new ArrayList(temp));
            }else{
                for(int i=start; i<candidates.length; i++){

                    if(candidates[i]  == pre){
                        continue;
                    }
                    pre = candidates[i];
                    temp.add(candidates[i]);
                    backTrack(result, candidates, target, i+1, sum+candidates[i], temp, -1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
