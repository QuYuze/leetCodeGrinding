package Playground;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();

            if(digits.length()==0){
                return result;
            }

            HashMap<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

            backTrack(result, digits, map, 0, "");
            return result;
        }

        private void backTrack(List<String> result, String digits, HashMap<Character, String> map, int index, String temp){
            if(temp.length()==digits.length()){
                result.add(temp);
            }else{
                String curr = map.get(digits.charAt(index));
                for(int i=0; i<curr.length(); i++){
                    backTrack(result, digits, map, index+1, temp+curr.charAt(i));
                }
            }
        }
    }
}
