package Playground;

import java.util.Arrays;

//https://leetcode.com/problems/task-scheduler/solutions/4894956/easy-explanation-greedy-beats-96-38-c-java-python3-kotlin/
public class taskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {

            int result = 0;

            int[] freq = new int[26];

            for(char t : tasks){
                freq[t - 'A']++;
            }

            Arrays.sort(freq);

            //num of time interval to complete most freq task
            int chunk = freq[25]-1;

            //max indle time will created
            int idle = chunk * n;

            //arrange all task into idle time, each task set into a time interval means idle time minus one
            for(int i=24; i>-1; i--){
                idle -= Math.min(chunk, freq[i]);

            }

            //if no idle, than it will just be same ask task length
            result = idle<0 ? tasks.length : tasks.length + idle;

            return result;
        }
    }
}
