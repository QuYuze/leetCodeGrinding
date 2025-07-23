package Playground;

public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 1 && matrix[0].length == 1){
                return matrix[0][0] - '0';
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int max = 0;

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    dp[i][j] = matrix[i][j] - '0';
                }
            }

            for(int i=m-1; i>=0; i--){
                for(int j=n-1; j>=0; j--){
                    if(dp[i][j] == 1){
                        if(i+1<m && j+1<n){
                            dp[i][j]= Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]) + 1;
                        }

                        max = Math.max(dp[i][j]*dp[i][j], max);
                    }
                }
            }

            return max;
        }
    }
}
