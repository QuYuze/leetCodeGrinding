package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[][] atlantic = new boolean[heights.length][heights[0].length];
            boolean[][] pacific = new boolean[heights.length][heights[0].length];

            for(int i=0; i<heights[0].length; i++){
                dfs(heights, 0, i, pacific, 0);
            }

            for(int i=0; i<heights.length; i++){
                dfs(heights, i, 0, pacific, 0);
            }

            for(int i=0; i<heights[0].length; i++){
                dfs(heights, heights.length-1, i, atlantic, 0);
            }

            for(int i=0; i<heights.length; i++){
                dfs(heights, i, heights[0].length-1, atlantic, 0);
            }

            for(int i=0; i<heights.length; i++){
                for(int j=0; j<heights[0].length; j++){
                    if(atlantic[i][j] && pacific[i][j]){
                        result.add(Arrays.asList(i, j));
                    }
                }
            }



            return result;

        }


        private void dfs(int[][] heights, int r, int c, boolean[][] result, int pre){
            if(r<0||c<0||r>=heights.length||c>=heights[0].length){
                return;
            }else{
                if(heights[r][c]>=pre && !result[r][c]){

                    result[r][c] = true;

                    dfs(heights, r-1, c, result, heights[r][c]);
                    dfs(heights, r+1, c, result, heights[r][c]);
                    dfs(heights, r, c-1, result, heights[r][c]);
                    dfs(heights, r, c+1, result, heights[r][c]);


                }
            }

        }
    }
}
