package Playground;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int result = 0;

            if(nums.length == 1){
                return nums[0];
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int num : nums){
                pq.add(num);
            }

            while(k>1){
                pq.poll();
                k--;
            }

            result = pq.poll();

            return result;
        }
    }
}
