package Playground;
//https://leetcode.com/problems/powx-n/description/

public class PowerXN {
    class Solution {
        public double myPow(double x, int n) {
            return power(x, (long) n);
        }

        private double power(double x, long n){
            if(n==0){
                return 1;
            }else if(n < 0){
                return power(1/x, -n);
            }else if(n%2==0){
                return power(x*x, n/2);
            }else{
                return x * power(x*x, (n-1)/2);
            }
        }
    }
}
