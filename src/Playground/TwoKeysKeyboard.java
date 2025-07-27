package Playground;

public class TwoKeysKeyboard {
    class Solution {
        public int minSteps(int n) {
            //int result = 0;
            if(n == 1){
                return 0;
            }

            int[] dp = new int[n+1];

            for(int i=2; i<=n; i++){
                dp[i] = i;
                for(int j=; j<=i/2; j++){

                    if(i%j == 0){
                        int count = dp[j] + i/j;
                        dp[i] = Math.min(dp[i], count);
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));

            return dp[n];
        }
    }
}
