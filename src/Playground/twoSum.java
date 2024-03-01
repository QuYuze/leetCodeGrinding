package Playground;

import java.util.HashMap;

public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i=0; i<nums.length; i++){

            if(map.containsKey(nums[i])){
                result = new int[]{map.get(nums[i]), i};
                break;
            }else{
                int complement = target - nums[i];
                map.put(complement, i);
            }
        }

        return result;


    }
}
