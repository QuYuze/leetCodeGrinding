package Playground;

import java.util.HashSet;
import java.util.Iterator;

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int result = 0;

            if(s.length()==1){
                return 1;
            }

            HashSet<Character> set = new HashSet<>();

            for(char c : s.toCharArray()){
                set.add(c);
            }

            Iterator<Character> iter = set.iterator();

            while(iter.hasNext()){
                char curr = iter.next();
                int count = 0;
                int left = 0;
                for(int right = 0; right<s.length(); right++){
                    if(s.charAt(right)!=curr){
                        count++;
                        while(count > k){
                            if(s.charAt(left)!=curr){
                                count--;
                            }
                            left++;
                        }
                    }
                    int currLength = right - left + 1;
                    result = currLength > result ? currLength : result;
                }

            }
            return result;
        }
    }
}
