package Playground;


//https://leetcode.com/problems/number-of-islands/
public class NumberIsland {

    class Solution {
        public int numIslands(char[][] grid) {

            int result = 0;

            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]=='1'){
                        result++;
                        markIsland(grid, i, j);
                    }
                }
            }

            return result;

        }

        private void markIsland(char[][] grid, int row, int col){
            if(row<0||col<0||row>=grid.length||col>=grid[0].length){
                return;
            }else{
                if(grid[row][col]=='0'||grid[row][col]=='.'){
                    return;
                }
                grid[row][col] = '.';
                markIsland(grid, row+1, col);
                markIsland(grid, row-1, col);
                markIsland(grid, row, col+1);
                markIsland(grid, row, col-1);
            }
        }
    }
}
