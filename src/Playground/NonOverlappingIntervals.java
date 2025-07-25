package Playground;

import java.util.Arrays;

public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length == 1){
                return 0;
            }

            int result = 1;

            Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

            int pre = 0;

            for(int i=1; i<intervals.length; i++){

                if(intervals[i][0] < intervals[pre][1]){
                    continue;
                }

                pre = i;
                result++;
            }

            return intervals.length - result;
        }
    }
}
