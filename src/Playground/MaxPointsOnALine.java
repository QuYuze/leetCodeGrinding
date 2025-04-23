package Playground;

import java.util.HashMap;

public class MaxPointsOnALine {
    class Solution {
        public int maxPoints(int[][] points) {
            int result = 1;

            if(points.length == 1){
                return 1;
            }

            for(int i=0; i<points.length; i++){
                HashMap<Double, Integer> map = new HashMap<>();
                for(int j=0; j<points.length; j++){
                    if(j == i){
                        continue;
                    }else{

                        double currSlope = slope(points[i][0], points[i][1], points[j][0], points[j][1]);
                        map.put(currSlope, map.getOrDefault(currSlope, 1)+1);
                        int count = map.get(currSlope);
                        result = result < count ? count : result;
                    }
                }
            }

            return result;
        }

        private double slope(int x, int y, int x2, int y2){
            if(x==x2){
                return Integer.MAX_VALUE;
            }else{
                return (y2 - y)*1.0/(x2 - x);
            }
        }
    }
}
