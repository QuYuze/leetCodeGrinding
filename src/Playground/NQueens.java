package Playground;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] grid = new char[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    grid[i][j] = '.';
                }
            }

            List<List<String>> result = new ArrayList<>();
            backtrack(result, grid, 0, n);


            return result;

        }

        private void backtrack(List<List<String>> result, char[][] grid, int i, int count){


            if(count == 0){
                List<String> temp = new ArrayList<>();
                for(char[] arr : grid){
                    temp.add(new String(arr));
                }
                result.add(temp);
                return;
            }else if(i == grid.length){
                return;
            }

            for(int j=0; j<grid[0].length; j++){
                if(isSafe(grid, i, j)){
                    grid[i][j] = 'Q';
                    backtrack(result, grid, i+1, count-1);
                    grid[i][j] = '.';
                    //System.out.println(i);
                }
            }
        }

        private boolean isSafe(char[][] grid, int i, int j){
            int x = i;
            int y = j;

            while(x >= 0){
                if(grid[x][y] == 'Q'){
                    return false;
                }
                x--;
            }

            x = i;

            while(x >= 0 && y >= 0){
                if(grid[x][y] == 'Q'){
                    return false;
                }
                x--;
                y--;
            }

            x = i;
            y = j;

            while(x >= 0 && y < grid[0].length){
                if(grid[x][y] == 'Q'){
                    return false;
                }
                x--;
                y++;
            }

            return true;
        }
    }
}
