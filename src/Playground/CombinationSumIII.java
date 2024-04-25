package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {

            List<List<Integer>> result = new ArrayList<>();
            backTrack(result, k, n, 0, new ArrayList(), 1);
            return result;
        }

        private void backTrack(List<List<Integer>> result, int k, int n, int sum, ArrayList<Integer> temp, int start){
            if(sum > n || temp.size()>k){
                return;
            }else if(temp.size()==k){
                if(sum == n){
                    result.add(new ArrayList(temp));
                }else{
                    return;
                }

            }else{
                for(int i=start; i<10; i++){

                    if(i+sum > n){
                        break;
                    }
                    temp.add(i);
                    backTrack(result, k, n, sum+i, temp, i+1);
                    temp.remove(temp.size()-1);
                }

            }
        }
    }
}
