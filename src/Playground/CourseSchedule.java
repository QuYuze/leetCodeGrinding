package Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


//https://leetcode.com/problems/course-schedule/solutions/3756938/beat-s-100-topo-c-java-python-beginner-friendly
public class CourseSchedule {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            if(prerequisites.length == 0){
                return true;
            }

            boolean result = false;
            HashMap<Integer, ArrayList> adj = new HashMap<>();
            int[] indep = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();

            for(int[] pair : prerequisites){
                int course = pair[0];
                int pre = pair[1];

                if(adj.containsKey(pre)){
                    adj.get(pre).add(course);
                }else{
                    adj.put(pre, new ArrayList<>());
                    adj.get(pre).add(course);

                }

                indep[course]++;
            }


            for(int i=0; i<indep.length; i++){
                if(indep[i]==0){
                    queue.add(i);
                }
            }

            if(queue.isEmpty()){
                return false;
            }else{
                ArrayList<Integer> ans = new ArrayList<>();
                while(!queue.isEmpty()){
                    int curr = queue.remove();
                    ans.add(curr);
                    if(adj.get(curr)!=null){
                        ArrayList<Integer> list = adj.get(curr);
                        for(int course : list){
                            indep[course]--;
                            if(indep[course]==0){
                                queue.add(course);
                            }
                        }
                    }
                }

                if(ans.size()==numCourses){
                    return true;
                };
            }

            return result;
        }
    }
}
