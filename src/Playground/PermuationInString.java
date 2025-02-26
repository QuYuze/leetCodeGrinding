package Playground;


//https://leetcode.com/problems/permutation-in-string/
public class PermuationInString {
    class Solution {

        public boolean checkInclusion(String s1, String s2) {
            boolean result = false;

            if(s1.equals(s2)){
                return true;
            }

            int[] s1Count = count(s1);
            int left = 0;
            int right = s1.length();

            while(right<=s2.length()){
                String curr = s2.substring(left, right);
                int[] currCount = count(curr);
                if(checkPerm(s1, s1Count, currCount)){
                    return true;
                }else{
                    left++;
                    right++;
                }

            }
            return result;
        }

        private boolean checkPerm(String s1, int[] count1, int[] count2){
            for(char c : s1.toCharArray()){
                int index = c-'a';
                if(count1[index]!=count2[index]){
                    return false;
                }
            }
            return true;
        }

        private int[] count(String s){
            int[] letterCount = new int[26];
            for(char c : s.toCharArray()){
                letterCount[c-'a']++;
            }
            return letterCount;
        }
    }
}
