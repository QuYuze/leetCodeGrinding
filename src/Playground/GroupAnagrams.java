package Playground;

import java.util.*;
//https://leetcode.com/problems/group-anagrams/


public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for(String str: strs){
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedStr = new String(charArray);
                map.putIfAbsent(sortedStr, new ArrayList<String>());
                map.get(sortedStr).add(str);
            }

            for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
                ArrayList<String> list = entry.getValue();
                result.add(list);
            }

            return result;
        }
    }
}
