package Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            int[] result = new int[numCourses];
            int[] indep = new int[numCourses];
            HashMap<Integer, ArrayList> map = new HashMap<>();

            for(int[] prereq : prerequisites){
                int course = prereq[0];
                int pre = prereq[1];

                indep[course]++;
                if(!map.containsKey(pre)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(course);
                    map.put(pre, temp);
                }else{
                    map.get(pre).add(course);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<numCourses; i++){
                if(indep[i]==0){
                    q.add(i);
                }

            }

            int order = 0;

            while(!q.isEmpty()){

                if(order>numCourses){
                    break;
                }
                int curr = q.remove();
                result[order] = curr;
                order++;

                if(map.containsKey(curr)){
                    ArrayList<Integer> adj = map.get(curr);
                    for(int course : adj){
                        indep[course]--;
                        if(indep[course]==0)
                            q.add(course);
                    }
                }

            }

            if(numCourses==order){
                return result;
            }else{
                int[] array = {};
                return array;
            }

        }
    }
}
