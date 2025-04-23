import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/lucky-numbers-in-a-matrix/

public class LuckNumber {
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int[] rowMin = new int[matrix.length];
            int[] colMax = new int[matrix[0].length];

            for(int i=0; i<matrix.length; i++){
                int min = matrix[i][0];
                for(int j=0; j<matrix[0].length; j++){
                    int curr = matrix[i][j];
                    min =  curr < min ? curr : min;
                }
                rowMin[i] = min;
            }

            for(int j=0; j<matrix[0].length; j++){
                int max = matrix[0][j];
                for(int i=0; i<matrix.length; i++){
                    int curr = matrix[i][j];
                    max =  curr > max ? curr : max;
                }
                colMax[j] = max;
            }

            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    int curr = matrix[i][j];
                    if(curr == rowMin[i] && curr == colMax[j]){
                        result.add(curr);
                    }
                }
            }

            return result;
        }
    }
}
