package Playground;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {

            String result = "";
            if(num.length() == 1 && k == 1){
                return "0";
            }

            Stack<Integer> stack = new Stack<>();
            int length = num.length() - k;
            int i= 0;
            while(i<num.length()){
                int curr = Character.getNumericValue(num.charAt(i));

                while(!stack.isEmpty() && curr < stack.peek() && k>0){
                    stack.pop();
                    k--;
                }
                stack.push(curr);i++;

            }

            while(stack.size() > length){
                stack.pop();
            }

            while(!stack.isEmpty()){

                int curr = stack.pop();
                result = Integer.toString(curr) + result;
                //System.out.println(result);
            }

            i = 0;
            while(i<result.length() && result.charAt(i)=='0'){
                i++;
            }

            result = result.substring(i);

            if(result.length()==0){
                return "0";
            }
            return result;
        }
    }
}
