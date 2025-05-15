package Playground;

//https://leetcode.com/problems/palindrome-number/

public class PalindromNumber {
    class Solution {
        public boolean isPalindrome(int x) {

            int result = 0;
            int target = x;

            while(x>0){
                result = result*10 + x%10;
                x = x/10;

            }

            if(result == target){
                return true;
            }

            return false;
        }
    }
}
