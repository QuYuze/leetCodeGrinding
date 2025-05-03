package Playground;

import java.util.HashMap;
import java.util.PriorityQueue;
//https://leetcode.com/problems/reorganize-string/
public class ReorgnizeString {
    class Solution {
        public String reorganizeString(String s) {
            String result = "";

            if(s.length()==1){
                return s;
            }

            HashMap<Character, Integer> map = new HashMap<>();
            for(char c: s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }

            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
            pq.addAll(map.keySet());

            while(pq.size()>1){
                char c1 = pq.remove();
                char c2 = pq.remove();

                map.put(c1, map.get(c1)-1);
                map.put(c2, map.get(c2)-1);

                result += c1;
                result += c2;

                if(map.get(c1)>0){
                    pq.add(c1);
                }
                if(map.get(c2)>0){
                    pq.add(c2);
                }
            }

            if(!pq.isEmpty()){
                char c = pq.remove();
                if(map.get(c)>1){
                    return "";
                }else{
                    result += c;
                }
            }


            return result;
        }
    }
}
