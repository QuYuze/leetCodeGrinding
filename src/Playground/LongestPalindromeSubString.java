package Playground;

public class LongestPalindromeSubString {
    class Solution {
        public String longestPalindrome(String s) {

            if(s.length() <= 1){
                return s;
            }else{
                int max = 0;
                int start = 0;
                int end = 0;

                for(int i=0; i<s.length(); i++){
                    int odd = find(s, i, i);
                    int even = find(s, i, i+1);
                    int length = Math.max(odd, even);

                    if(length > max){
                        start = i - (length - 1) / 2;
                        end = i + length/ 2;
                        max = length;
                    }
                }

                return  s.substring(start, end+1);
            }

        }

        private int find(String s, int left, int right){
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
}
