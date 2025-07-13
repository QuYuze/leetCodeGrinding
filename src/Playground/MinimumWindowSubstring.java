package Playground;

import java.util.HashMap;

public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if(s.length() < t.length()){
                return "";
            }

            int start = -1;
            int end = -1;
            int length = Integer.MAX_VALUE;

            HashMap<Character, Integer> target = new HashMap<>();

            for(char c : t.toCharArray()){
                target.put(c, target.getOrDefault(c, 0)+1);
            }

            int left = 0;
            int right = 0;
            int targetCount = t.length();

            while(right < s.length()){
                char curr = s.charAt(right);

                if(target.containsKey(curr) && target.get(curr) > 0){
                    targetCount--;
                }


                target.put(curr, target.getOrDefault(curr, 0) - 1);

                if(targetCount == 0){

                    while(true){
                        char leftChar = s.charAt(left);
                        if(target.get(leftChar) == 0){
                            break;
                        }
                        target.put(leftChar, target.get(leftChar)+1);
                        left++;
                    }

                    int currLength = right - left + 1;

                    if(length > currLength){
                        length = currLength;
                        start = left;
                        end = right;
                    }

                    target.put(s.charAt(left), 1);
                    targetCount++;
                    left++;
                }

                right++;

            }

            if(start == -1){
                return "";
            }else{
                return s.substring(start, end+1);
            }

        }

    }
}
