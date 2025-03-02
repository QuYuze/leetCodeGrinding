package Playground;

import java.util.ArrayList;
import java.util.Arrays;

public class mergIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            ArrayList<int[]> result = new ArrayList<>();
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int right = 0;
            int left = 0;
            int r = intervals[left][0];
            int l = intervals[right][1];

            while(right<intervals.length){
                l = Math.min(intervals[left][0], l);
                r = Math.max(intervals[right][1], r);
                if(right<intervals.length-1){
                    if(intervals[right+1][0]>r){
                        result.add(new int[]{l, r});
                        left = right+1;
                        l=intervals[left][0];
                    }
                }else if(right == intervals.length-1){
                    result.add(new int[]{l, r});

                }
                right++;
            }


            int[][] resultArray = new int[result.size()][2];
            for(int i=0; i<resultArray.length; i++){
                resultArray[i][0] = result.get(i)[0];
                resultArray[i][1] = result.get(i)[1];
            }

            return resultArray;
        }
    }
}
