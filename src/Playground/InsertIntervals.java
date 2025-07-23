package Playground;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    //do it iteratively using linear approach
     class Solution1 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();

            if(intervals.length == 0){
                result.add(newInterval);
            }else{
                boolean added = false;

                for(int[] interval : intervals){
                    if(!added){
                        if(interval[0] > newInterval[1]){
                            result.add(newInterval);
                            result.add(interval);
                            added = true;
                        }else if(interval[1] < newInterval[0]){
                            result.add(interval);
                        }else{
                            newInterval[0] = Math.min(newInterval[0], interval[0]);
                            newInterval[1] = Math.max(newInterval[1],  interval[1]);
                            result.add(newInterval);
                            added = true;
                        }
                    }else{

                        int[] pre = result.get(result.size()-1);
                        if(interval[0] > pre[1]){
                            result.add(interval);
                        }else{
                            pre[0] = Math.min(pre[0], interval[0]);
                            pre[1] = Math.max(pre[1],  interval[1]);
                        }

                    }
                }

                if(!added){
                    result.add(newInterval);
                }
            }

            return result.toArray(new int[0][0]);
        }
    }
}
