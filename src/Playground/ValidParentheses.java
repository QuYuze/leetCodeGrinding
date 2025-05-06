package Playground;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {

            if(s.length()==1){
                return false;
            }

            HashMap<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            Stack<Character> stack = new Stack<>();

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }
                if(map.containsKey(c)){
                    char open = '.';

                    if(!stack.isEmpty()){
                        open = stack.peek();
                    }else{
                        return false;
                    }

                    if(open != map.get(c)){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty()){
                return false;
            }

            return true;
        }
    }
}
