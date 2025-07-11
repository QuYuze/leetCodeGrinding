package Playground;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    class Solution {
        public void setZeroes(int[][] matrix) {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(matrix[i][j]==0){
                        if(!row.contains(i)){
                            row.add(i);
                        }

                        if(!col.contains(j)){
                            col.add(j);
                        }
                    }
                }
            }

            Iterator<Integer> iter = row.iterator();
            while(iter.hasNext()){
                int r = iter.next();
                Arrays.fill(matrix[r], 0);
            }

            iter = col.iterator();
            while(iter.hasNext()){
                int c = iter.next();
                for(int i=0; i<matrix.length; i++){
                    matrix[i][c] = 0;
                }
            }
        }
    }


    //use constant space
    class Solution2 {
        public void setZeroes(int[][] matrix) {

            if(matrix.length == matrix[0].length && matrix.length == 1){
                return;
            }

            boolean firstRow = false;
            boolean firstCol = false;

            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                        if(i == 0){
                            firstRow = true;
                        }

                        if(j == 0){
                            firstCol = true;
                        }
                    }
                }
            }

            for(int i=matrix.length-1; i>=1; i--){
                for(int j=matrix[0].length-1; j>=1; j--){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }

            if(firstRow){
                Arrays.fill(matrix[0], 0);
            }

            if(firstCol){
                for(int i=0; i<matrix.length; i++){
                    matrix[i][0] = 0;
                }
            }


        }
    }
}
