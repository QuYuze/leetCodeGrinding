package Playground;

import java.util.*;


//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {

    //nlogN Solution
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {

            int[] result = new int[k];

            if(nums.length == 1){
                return nums;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0)+1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(b)-map.get(a));

            pq.addAll(map.keySet());
            int i=0;

            while(i<k){
                result[i] = pq.remove();
                i++;
            }

            return result;
        }
    }

    //O(n) solution, Uses Bucket sort
    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {

            int[] result = new int[k];

            if(nums.length == 1){
                return nums;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0)+1);
            }


            Queue<Integer>[] bucket = new LinkedList[nums.length+1];
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getKey();
                int count = entry.getValue();
                if(bucket[count] == null){
                    bucket[count] = new LinkedList<Integer>();
                }
                bucket[count].add(num);
            }

            int i= nums.length;
            int index = 0;
            while(k>0 && i>=0){
                if(bucket[i]!=null){
                    Queue<Integer> curr = bucket[i];

                    while(!curr.isEmpty() && k>0){
                        int num = curr.remove();
                        result[index] = num;
                        index++;
                        k--;
                    }
                }

                i--;
            }

            return result;
        }
    }
}
