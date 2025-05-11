package Playground;

import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/exclusive-time-of-functions/

public class ExclusiveTime {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];

            Stack<Log> stack = new Stack<>();

            for(String log : logs){
                String[] parsed = log.split(":");
                int id = Integer.valueOf(parsed[0]);
                String event = parsed[1];
                int time = Integer.valueOf(parsed[2]);

                if(event.equals("start")){

                    if(!stack.isEmpty()){
                        Log pre = stack.peek();
                        result[pre.id] += time-pre.start;
                    }
                    stack.push(new Log(id, time));

                }else if(event.equals("end")){

                    result[id] += time + 1 - stack.pop().start;

                    if(!stack.isEmpty()){
                        Log pre = stack.peek();
                        pre.setStart(time+1);
                    }

                }
            }

            return result;
        }

        public class Log{
            int id = 0;
            int start = 0;
            public Log(int id, int start){
                this.id = id;
                this.start = start;
            }

            public void setStart(int start){
                this.start = start;
            }
        }
    }
}
