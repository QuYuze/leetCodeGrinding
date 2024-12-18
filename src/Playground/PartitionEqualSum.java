package Playground;

//https://leetcode.com/problems/partition-equal-subset-sum/solutions/1624101/java-memoization-to-optimized-dp-detailed-explanation/
public class PartitionEqualSum {
    class Solution {
        public boolean canPartition(int[] nums) {

            int sum = 0;

            for(int n : nums){
                sum += n;
            }

            if(sum%2 != 0){
                return false;
            }

            int sack = sum/2;
            int items = nums.length;

            boolean[][] dp = new boolean[items+1][sack+1];

            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j] = false;
                    }else if(nums[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }else if(nums[i-1] == j){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }

            return dp[items][sack];

        }
    }
}
