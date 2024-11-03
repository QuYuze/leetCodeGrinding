package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/solutions/5194946/java-solution-using-backtracking/

public class palindromePartitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();

            backTrack(result, new ArrayList(), s, 0);

            return result;
        }

        private void backTrack(List<List<String>> result, List<String> temp, String s, int index){
            if(index == s.length()){
                result.add(new ArrayList(temp));
                return;
            }else{
                for(int i=index; i<s.length(); i++){
                    if(isPalindrome(s, index, i)){
                        temp.add(s.substring(index, i+1));
                        backTrack(result, temp, s, i+1);
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end){
            while(start <= end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }else{
                    start++;
                    end--;
                }
            }
            return true;
        }
    }
}
