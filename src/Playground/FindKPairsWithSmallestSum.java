package Playground;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for(int x : nums1){
                pq.add(new int[]{x+nums2[0], 0});
            }


            while(k > 0 && !pq.isEmpty()){
                int[] pair = pq.poll();
                int sum = pair[0];
                int secondIndex = pair[1];
                int second = nums2[secondIndex];
                int first = sum - second;

                List<Integer> resultPair = new ArrayList<>();
                resultPair.add(first);
                resultPair.add(second);
                result.add(resultPair);

                if(secondIndex + 1 < nums2.length){
                    pq.add(new int[]{first + nums2[secondIndex+1], secondIndex+1});
                }

                k--;


            }

            return result;
        }
    }
}
