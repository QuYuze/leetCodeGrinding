package Playground;

public class SeparateSquares {
    class Solution {
        public double separateSquares(int[][] squares) {
            double left = 0;
            double right = 2*1e10;
            double tolerance = 1e-5;

            while(left + tolerance <= right){

                double mid = left + (right - left) / 2.0;

                if(helper(mid, squares) > 0){
                    left = mid;

                }else{
                    right = mid;
                }

            }

            return left + (right - left) / 2.0;
        }


        private double helper(double line, int[][] squares){
            double above = 0;
            double below = 0;

            for(int i=0; i<squares.length; i++){
                int[] square =squares[i];
                int y = square[1];
                int l = square[2];
                double area = (double) l * l;

                if(line <= y){
                    above += area;
                }else if(line >= y+l){
                    below += area;
                }else{
                    double aboveHeight = (y + l) - line;
                    double belowHeight = line - y;
                    above += l * aboveHeight;
                    below += l * belowHeight;
                }

            }

            //System.out.println(above + " : " + below);

            return above - below;
        }
    }
}
