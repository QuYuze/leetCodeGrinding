package Playground;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length-k+1];

            int left = 0;
            int right = left + k -1;
            Deque<Integer> dq = new LinkedList<>();
            for(int i=left; i<=right; i++){
                while(!dq.isEmpty() && dq.peekLast() < nums[i]){
                    dq.removeLast();
                }
                dq.addLast(nums[i]);
            }
            result[0] = dq.peekFirst();
            int index = 0;

            while(right+1 < nums.length){
                right++;

                if(dq.peekFirst() == nums[left]){
                    dq.removeFirst();
                }

                left++;
                index++;

                while(!dq.isEmpty() && dq.peekLast() < nums[right]){
                    dq.removeLast();
                }

                dq.add(nums[right]);

                result[index] = dq.peekFirst();


            }

            return result;
        }
    }
}



