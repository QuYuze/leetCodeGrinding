package Playground;

import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/word-break/solutions/6113383/simple-solution-with-diagrams-in-video-javascript-c-java-python/

public class WordBreak {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] dp = new boolean[s.length()+1];
            boolean result = false;
            HashSet<String> set = new HashSet<>(wordDict);

            dp[0] = true;

            for(int i=1; i<dp.length; i++){
                for(int j=0; j<i; j++){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        System.out.println(s.substring(j, i));
                        dp[i] = true;
                        break;
                    }
                }
            }

            result = dp[s.length()];

            return result;
        }
    }
}
