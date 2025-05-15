package Playground;
//https://leetcode.com/problems/power-of-two/solutions/6707832/100-beats-power-of-two-without-recursion-loop/
public class PowerOfTwo {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n<=0){
                return false;
            }else if((n & (n-1)) == 0){
                return true;
            }

            return false;
        }
    }
}
