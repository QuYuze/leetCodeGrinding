package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            HashMap<Integer, Integer> prefix = new HashMap<>();
            HashMap<Integer, Integer> suffix = new HashMap<>();

            int product = 1;
            for(int i=0; i<nums.length; i++){
                if(i-1>=0){
                    product = product * nums[i-1];
                    prefix.put(i, product);
                }
            }

            product = 1;
            for(int i=nums.length-1; i>-1; i--){
                if(i+1<=nums.length-1){
                    product = product * nums[i+1];
                    suffix.put(i, product);
                }
            }

            for(int i=0; i<nums.length; i++){
                int pre = 1;
                int suf = 1;
                if(prefix.containsKey(i)){
                    pre = prefix.get(i);
                }
                if(suffix.containsKey(i)){
                    suf = suffix.get(i);
                }
                result[i] = pre * suf;
            }



            return result;
        }
    }
}
