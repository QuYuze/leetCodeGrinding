package Playground;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/rotting-oranges/

public class RottingOrange {
    class Solution {
        public int orangesRotting(int[][] grid) {

            int result = 0;
            int m = grid.length;
            int n = grid[0].length;
            int fresh = 0;
            Queue<int[]> q = new LinkedList<>();

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] == 2){
                        grid[i][j] = -1;
                        q.add(new int[]{i, j});
                    }
                    if(grid[i][j] == 1){
                        fresh++;
                    }
                }
            }

            while(!q.isEmpty() && fresh > 0){
                int size = q.size();
                result++;
                while(size > 0){
                    int[] coor = q.remove();
                    int i = coor[0];
                    int j = coor[1];

                    if(i-1 >= 0){
                        if(grid[i-1][j] == 1){
                            grid[i-1][j] = -1;
                            fresh--;
                            q.add(new int[]{i-1, j});
                        }
                    }

                    if(i+1<m){
                        if(grid[i+1][j] == 1){
                            grid[i+1][j] = -1;
                            fresh--;
                            q.add(new int[]{i+1, j});
                        }
                    }

                    if(j-1 >= 0){
                        if(grid[i][j-1] == 1){
                            grid[i][j-1] = -1;
                            fresh--;
                            q.add(new int[]{i, j-1});
                        }
                    }

                    if(j+1 < n){
                        if(grid[i][j+1] == 1){
                            grid[i][j+1] = -1;
                            fresh--;
                            q.add(new int[]{i, j+1});
                        }
                    }

                    size--;
                }
            }

            if(fresh > 0){
                return -1;
            }


            return result;
        }
    }
}
