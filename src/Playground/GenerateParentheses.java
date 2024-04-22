package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {

    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> result = new ArrayList<>();

            generate(result, "", 0, 0, n);


            return result;
        }

        private void generate(List<String> result, String temp, int left, int right, int n){
            if(left == right && left == n){
                result.add(new String(temp));
            }else{
                if(left==right){
                    generate(result, temp+'(', left+1, right, n);
                }else if(left<=n && left>right){

                    generate(result, temp+')', left, right+1, n);

                    if(left<n){
                        generate(result, temp+'(', left+1, right, n);
                    }

                }
            }

        }
    }
}
