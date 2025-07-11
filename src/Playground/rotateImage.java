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

    class Solution2 {
        public void rotate(int[][] matrix) {

            int left = 0;
            int right = matrix[0].length-1;;
            int top = 0;
            int bottom = matrix.length-1;

            while(left<right && top<bottom){


                for(int i=0; i<(right - left); i++){
                    int temp = matrix[top+i][right];
                    matrix[top+i][right] = matrix[top][i+left];

                    int temp1 = matrix[bottom][right-i];
                    matrix[bottom][right-i] = temp;

                    matrix[top][i+left] = matrix[bottom-i][left];
                    matrix[bottom-i][left] = temp1;
                    //System.out.println(temp+" "+temp1);

                }

                left++;
                right--;
                top++;
                bottom--;
            }
        }
    }
}
