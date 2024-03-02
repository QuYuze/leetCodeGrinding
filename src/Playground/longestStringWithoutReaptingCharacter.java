package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class longestStringWithoutReaptingCharacter {


    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int currLength = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                rightIndex = i;
                map.put(c, i);
                currLength = rightIndex - leftIndex + 1;
                if(currLength>maxLength){
                    maxLength = currLength;
                }
            }else{
                rightIndex = i;
                if(map.get(c)>=leftIndex){
                    leftIndex = map.get(c)+1;
                }
                map.remove(c);
                map.put(c, i);
                currLength = rightIndex - leftIndex + 1;
                if(currLength>maxLength){
                    maxLength = currLength;
                }
            }
        }

        result = maxLength;
        return result;
    }
}
