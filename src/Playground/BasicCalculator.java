package Playground;

import java.util.Stack;

public class BasicCalculator {
    class Solution {
        public int calculate(String s) {
            int result = 0;
            int sign = 1;
            int number = 0;
            Stack<Integer> stack = new Stack<>();


            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);

                if(Character.isDigit(c)){
                    number = number * 10 + (c - '0');
                }else if(c == '+'){
                    result += sign * number;
                    number = 0;
                    sign = 1;
                }else if(c == '-'){
                    result += sign * number;
                    number = 0;
                    sign = -1;
                }else if(c == '('){
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                }else if(c == ')'){
                    result += sign * number;
                    //System.out.println(result);
                    number = 0;
                    result *= stack.pop();
                    result += stack.pop();
                }

            }

            if(number > 0){
                result += sign * number;
            }


            return result;
        }
    }
}
