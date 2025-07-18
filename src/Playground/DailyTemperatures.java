package Playground;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];

            if(temperatures.length == 0){
                return result;
            }

            Stack<Integer> stack = new Stack<>();
        /*

        75 - 2



        76 - 6

        [0, 0, 4, 2, 1, 1, 0, 0]
        */

            for(int i=temperatures.length-1; i>=0; i--){
                int currTemp = temperatures[i];

                while(!stack.isEmpty() && currTemp >= temperatures[stack.peek()]){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    result[i] = stack.peek() - i;
                }

                stack.push(i);
            }

            return result;
        }
    }
}
