package Playground;

import java.util.Stack;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            String result = "";
            String[] list = path.split("/+");
            Stack<String> stack = new Stack<>();

            for(int i=0; i<list.length; i++){
                String curr = list[i];
                if(curr.length() > 0 && !curr.equals(".") ){
                    if(curr.equals("..")){
                        if(!stack.isEmpty())
                            stack.pop();
                    }else{
                        stack.push(curr);
                    }

                }
            }

            while(!stack.isEmpty()){
                result = "/" + stack.pop() + result;
            }

            if(result.length()==0){
                result = "/";
            }

            return result;
        }
    }
}
