package Playground;

public class FillSpecialGrid {
    class Solution {

        int val = 0;

        public int[][] specialGrid(int n) {
            int size = (int) Math.pow(2, n);
            int[][] result = new int[size][size];
            fill(result, 0, 0, size);
            return result;
        }

        private void fill(int[][] result, int r, int c, int size){
            if(size == 1){
                result[r][c] = val++;
                return;
            }else{
                int sub = size / 2;
                fill(result, r, c+sub, sub);
                fill(result, r+sub, c+sub, sub);
                fill(result, r+sub, c, sub);
                fill(result, r, c, sub);
            }
        }
    }
}
