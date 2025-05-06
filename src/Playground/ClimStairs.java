package Playground;

//https://leetcode.com/problems/climbing-stairs/
public class ClimStairs {
    class Solution {
        public int climbStairs(int n) {
            int result = 0;
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            int pre1 = 1;
            int pre2 = 2;

            for(int i=3; i<=n; i++){
                result = pre1 + pre2;
                pre1 = pre2;
                pre2 = result;
            }
            return result;
        }
    }
}
