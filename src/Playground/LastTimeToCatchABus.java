package Playground;

import java.util.*;

//https://leetcode.com/problems/the-latest-time-to-catch-a-bus/description/
public class LastTimeToCatchABus {

    class Solution {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

            int result = 0;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            Arrays.sort(buses);
            Arrays.sort(passengers);


            int j = 0;
            for(int i=0; i<buses.length; i++){
                int bus = buses[i];
                List<Integer> list = new ArrayList<>();
                while(list.size()<capacity && j < passengers.length){
                    if(passengers[j] <= bus){
                        list.add(passengers[j]);
                    }else{
                        break;
                    }
                    j++;
                    if(j==passengers.length){
                        break;
                    }
                }
                map.put(bus, list);
            }

            for(int pass : passengers){
                set.add(pass);
            }

            for(int i=buses.length-1; i>=0; i--){
                int bus = buses[i];
                List<Integer> list = map.get(bus);
                if(list.isEmpty()){
                    return bus;
                }

                int curr = list.get(list.size()-1);

                if(list.size()<capacity){
                    curr = bus;
                }

                while(set.contains(curr)){
                    curr--;
                }
                return curr;
            }

            return result;
        }
    }
}
