package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
/*
    intuitive solution would be using HashSet,
    however, the problem dictates that only constant auxiliary space would be used.
    that leaves to two options, modifies the array in place or uses pointers.
    naturally, marking visited element would be very easy to implement.

 */
public class FindAllDuplicatesInArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            List<Integer> result = new ArrayList<Integer>();

            for(int n : nums){
                int index = n<0 ? (n*-1)-1 : n-1;
                int numAtIndex = nums[index];

                if(numAtIndex<0){
                    result.add(Math.abs(n));
                }else{
                    nums[index] *= -1;
                }
            }

            return result;
        }
    }
}
