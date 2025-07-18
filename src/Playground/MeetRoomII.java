package Playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetRoomII {


    //O(n) time complexity
    class Solution {
        public int minMeetingRooms(int[] start, int[] end) {

            List<int[]> intervals = new ArrayList<>();
            int maxEnd = 0;
            for(int i=0; i<start.length; i++){
                int[] interval = new int[]{start[i], end[i]};
                intervals.add(interval);
                maxEnd = Math.max(maxEnd, end[i]);
            }

            //Collections.sort(intervals, (a, b)->(a[0] - b[0]));
            int[] diff = new int[maxEnd+1];

            for(int[] interval : intervals){
                diff[interval[0]]++;
                if(interval[1]< diff.length){
                    diff[interval[1]]--;
                }
            }


            int prefix = 0;
            int result = 0;
            for(int i=0; i<diff.length; i++){
                prefix += diff[i];
                result = Math.max(result, prefix);
            }

//System.out.println(Arrays.toString(diff));

            return result;

        }
    }

}
