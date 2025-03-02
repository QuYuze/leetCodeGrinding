package Playground;

import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubStringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;

            if(s.length() <= 1){
                return s.length();
            }

            int left = 0;
            HashSet<Character> set = new HashSet<>();

            for(int right = 0; right<s.length(); right++){

                char currChar = s.charAt(right);

                while(set.contains(currChar)){
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(currChar);
                int currLength = right - left + 1;
                result = currLength > result ? currLength : result;
            }


            return result;
        }
    }
}
