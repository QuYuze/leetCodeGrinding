package Playground;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int result = 1;

            if(nums.length==1){
                return result;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for(int i=0; i<nums.length; i++){

                int curr = nums[i];
                for(int j=i-1; j>=0; j--){
                    int currLength = 1;
                    if(nums[j]<curr){
                        currLength += dp[j];
                    }
                    dp[i] = currLength > dp[i] ? currLength : dp[i];
                }

                result = dp[i] > result ? dp[i] : result;
            }

            return result;
        }
    }
}
