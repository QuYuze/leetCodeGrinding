package Playground;

import java.util.HashMap;

public class HouseRobberII {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        int result1 = robFirst(nums.length-2, nums);
        int result2 = robSecond(nums.length-1, nums);
        return Math.max(result1, result2);
    }

    public int robFirst(int i, int[] nums){
        int result = 0;
        if(i<0){
            return 0;
        }

        if(map.containsKey(i)){
            return map.get(i);
        }

        result = Math.max(nums[i]+robFirst(i-2, nums), robFirst(i-1, nums));
        map.put(i, result);

        return result;
    }

    public int robSecond(int i, int[] nums){
        int result = 0;

        if(i<1){
            return 0;
        }

        if(map.containsKey(-1*i)){
            return map.get(-1*i);
        }
        result = Math.max(nums[i]+robSecond(i-2, nums), robSecond(i-1, nums));
        map.put(-1*i, result);

        return result;
    }
}
