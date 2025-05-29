package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraySum {
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int result = 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;

            for(int n : nums){
                if(n == k){
                    result++;
                }

                int complement = sum + n - k;

                if(map.containsKey(complement)){
                    result += map.get(complement);
                }

                map.putIfAbsent(sum, 0);
                map.put(sum, map.get(sum)+1);
                sum += n;
            }


            return result;
        }
    }
}
