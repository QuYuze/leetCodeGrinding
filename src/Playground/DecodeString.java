package Playground;

import java.util.Stack;

public class DecodeString {
    class Solution {
        public String decodeString(String s) {

            Stack<Integer> count = new Stack<>();
            Stack<StringBuilder> msg = new Stack<>();
            StringBuilder str = new StringBuilder();
            int n = 0;

            for(char c : s.toCharArray()){
                if(Character.isDigit(c)){
                    n = n*10 + (c - '0');
                }else if(c == '['){
                    count.push(n);
                    n = 0;
                    msg.push(str);
                    str = new StringBuilder();

                }else if(c == ']'){
                    StringBuilder temp = str;
                    int currCount = count.pop();
                    str = msg.pop();

                    while(currCount > 0){
                        str.append(temp);
                        currCount--;
                    }

                }else{
                    str.append(c);
                }
            }

            return str.toString();
        }
    }
}
