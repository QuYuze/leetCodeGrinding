package Playground;

public class MaxAreaOfIsland {

    //https://leetcode.com/problems/max-area-of-island/
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {

            int result = 0;

            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==1){
                        int area = dfs(grid, i, j);
                        result = area > result ? area : result;
                    }

                }
            }

            return result;
        }

        private int dfs(int[][] grid, int i, int j){
            if(i <0 || i>= grid.length || j<0 || j>= grid[0].length){
                return 0;
            }else if(grid[i][j] == 0 || grid[i][j] == -1){
                return 0;
            }else{
                grid[i][j] = -1;
                return 1 + dfs(grid, i-1, j)
                        + dfs(grid, i+1, j)
                        + dfs(grid, i, j-1)
                        + dfs(grid, i, j+1);
            }
        }
    }
}
