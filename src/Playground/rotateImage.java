package Playground;

public class rotateImage {
    class Solution {
        public void rotate(int[][] matrix) {

            int top = 0;
            int bottom = matrix.length-1;
            int left = 0;
            int right = matrix[0].length-1;

            while(top<=bottom && left<=right){


                if(left!=right && top!=bottom){
                    for(int i=0; i<right-left; i++){

                        int tempA = matrix[i+top][right]; //8
                        matrix[i+top][right] = matrix[top][i+left];


                        int tempB = matrix[bottom][right-i]; //6
                        matrix[bottom][right-i] = tempA;

                        tempA = matrix[bottom-i][left]; // 3
                        matrix[bottom-i][left] = tempB;

                        matrix[top][i+left] = tempA;
                    }
                }

                top++;
                bottom--;
                left++;
                right--;
            }

        }
    }
}
