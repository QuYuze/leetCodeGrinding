package Playground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDuplicatesInArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            List<Integer> result = new ArrayList<>();

            if(nums.length == 1){
                return result;
            }

            HashSet<Integer> set = new HashSet<>();

            for(int num : nums){
                if(!set.contains(num)){
                    set.add(num);
                }else{
                    result.add(num);
                }
            }


            return result;
        }
    }
}
