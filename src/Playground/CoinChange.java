package Playground;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/solutions/5117751/video-keep-minimum-number-of-coins-to-make-up-each-amount

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {

            int result = 0;

            if(amount == 0){
                return 0;
            }

            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;

            for(int i=1; i<dp.length; i++){

                int currentAmount = i;

                for(int j=0; j<coins.length; j++){
                    int rest = currentAmount - coins[j];
                    int num = 0;
                    if(rest >= 0){
                        num = 1 + dp[rest];
                        if(num < dp[i]){
                            dp[i] = num;
                        }
                    }
                }
            }

            if(dp[amount] == amount+1){
                return -1;
            }else{
                return dp[amount];
            }




        }
    }
}
