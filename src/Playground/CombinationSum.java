package Playground;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, candidates, target, 0, new ArrayList(), 0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, int[] candidates, int target, int sum, ArrayList<Integer> temp, int start){
            if(sum > target){
                return;
            }else if(sum == target){
                result.add(new ArrayList(temp));
            }else{
                for(int i=start; i<candidates.length; i++){
                    temp.add(candidates[i]);
                    backtrack(result, candidates, target, sum +candidates[i], temp, start);
                    temp.remove(temp.size()-1);
                    start++;
                }
            }
        }
    }
}
