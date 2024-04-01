package Playground;

import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/house-robber/solutions/156523/from-good-to-great-how-to-approach-most-of-dp-problems
public class HouseRobber {


        static HashMap<Integer, Integer> map = new HashMap<>();

        public static void main(String[] args){

            int[] nums = {2,7,9,3,1};
            HouseRobber robber = new HouseRobber();
            HouseRobber.Solution1 sol1 = robber.new Solution1();
            HouseRobber.Solution2 sol2 = robber.new Solution2();
            System.out.println(sol1.rob(nums));
            System.out.println(sol2.rob(nums));

        }

        public int rob(int[] nums) {

            if(nums.length == 0)
                return 0;
            int result = rob(nums.length-1, nums);

            return result;
        }

        public int rob(int index, int[] nums){

            if(index<0){
                return 0;
            }

            if(map.containsKey(index)){
                return map.get(index);
            }else{
                int result = Math.max(nums[index] + rob(index-2, nums), rob(index-1, nums));
                map.put(index, result);
                return result;
            }

        }
    public class Solution1 {

        static HashMap<Integer, Integer> map;

        public int rob(int[] nums) {

            map = new HashMap<>();

            if(nums.length == 0)
                return 0;
            int result = rob(nums.length-1, nums);
            //System.out.println(map);

            return result;
        }

        public int rob(int index, int[] nums){

            if(index<0){
                return 0;
            }

            if(map.containsKey(index)){
                return map.get(index);
            }else{
                int result = Math.max(nums[index] + rob(index-2, nums), rob(index-1, nums));
                map.put(index, result);
                return result;
            }

        }
    }


    //much neater solution make used of array instead of HashMap, beat 100%
    public class Solution2{
        int[] memo;
        public int rob(int[] nums) {
            memo = new int[nums.length + 1];
            Arrays.fill(memo, -1);
            return rob(nums, nums.length - 1);
        }

        private int rob(int[] nums, int i) {
            if (i < 0) {
                return 0;
            }
            if (memo[i] >= 0) {
                return memo[i];
            }
            int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
            memo[i] = result;
            return result;
        }

    }
}
