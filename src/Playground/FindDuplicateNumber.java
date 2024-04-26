package Playground;

import java.util.HashSet;


//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {

    class Solution {
        public int findDuplicate(int[] nums) {

            HashSet<Integer> set = new HashSet<>();

            for(int num : nums){
                if(!set.contains(num)){
                    set.add(num);
                }else{
                    return num;
                }
            }

            return 0;

        }
    }
}
