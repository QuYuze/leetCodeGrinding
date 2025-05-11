package Playground;

import java.util.HashSet;

//https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            String result = "";
            int min = 201;

            for(String str: strs){
                int length = str.length();
                min = min < length ? min : length;
            }

            for(int i=0; i<min; i++){

                HashSet<Character> set = new HashSet<>();
                char c = '.';
                for(String str: strs){
                    c = str.charAt(i);
                    set.add(c);
                    if(set.size() > 1){
                        break;
                    }
                }
                if(set.size() == 1){
                    result += c;
                }else{
                    break;
                }
            }

            return result;
        }
    }
}
