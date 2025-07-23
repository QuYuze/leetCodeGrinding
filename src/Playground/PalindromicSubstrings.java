package Playground;

public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            if(s.length() == 1){
                return 1;
            }

            int result = 0;
            for(int i=0; i<s.length(); i++){
                int even = find(s, i, i+1);
                int odd = find(s, i, i);
                result = result + even + odd;
            }

            return result;
        }

        private int find(String s, int i, int j){
            int result = 0;

            while(i >= 0 && j <s.length() && s.charAt(i) == s.charAt(j)){
                result++;
                i--;
                j++;
            }

            return result;
        }
    }
}
