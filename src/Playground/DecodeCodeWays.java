package Playground;

public class DecodeCodeWays {

    class Solution {


        public int numDecodings(String s) {
            int result = 0;

            if(s.charAt(0) == '0'){
                return result;
            }

            int[] dp = new int[s.length()+1];

            dp[0] = 1;
            dp[1] = 1;

            for(int i=2; i<dp.length; i++){
                boolean combine = false;
                boolean alone = false;

                if(s.charAt(i-1) != '0'){
                    alone = true;
                }

                if(Integer.parseInt(s.substring(i-2, i)) <= 26 && s.charAt(i-2)!='0'){
                    combine = true;
                }

                if(i<dp.length-1){
                    if(s.charAt(i) == '0'){
                        combine = false;
                    }
                }

                if(alone){
                    dp[i] += dp[i-1];
                }

                if(combine){
                    dp[i] += dp[i-2];
                }

            }

            return dp[dp.length-1];
        }



    }
}
