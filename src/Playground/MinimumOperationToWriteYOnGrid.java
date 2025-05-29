package Playground;

public class MinimumOperationToWriteYOnGrid {
    class Solution {
        public int minimumOperationsToWriteY(int[][] grid) {

            int result = Integer.MAX_VALUE;
            int[] y = new int[3];
            int[] nonY = new int[3];
            int yCount = 0;
            int nonYCount = 0;
            int mid = (grid.length-1)/2;

            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid.length; j++){
                    if((i==j && i<=mid) || (grid.length-1-j == i && i<=mid)){
                        y[grid[i][j]]++;
                        yCount++;
                    }else if(j==mid && i>mid){
                        y[grid[i][j]]++;
                        yCount++;
                    }else{
                        nonY[grid[i][j]]++;
                        nonYCount++;
                    }
                }
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i!=j){
                        int curr = nonYCount-nonY[j] + (yCount-y[i]);
                        result = result > curr ? curr : result;
                    }
                }
            }

            return result;
        }
    }
}
