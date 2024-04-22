package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class Combinations {

    class Solution {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> result = new ArrayList<>();

            backtrack(result, n, k, 1, new ArrayList());

            return result;

        }

        private void backtrack(List<List<Integer>> result, int n, int k, int start, ArrayList<Integer> temp){
            if(temp.size()==k){
                result.add(new ArrayList(temp));
            }else{
                for(int i=start; i<n+1; i++){
                    temp.add(i);
                    backtrack(result, n, k, i+1, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
