package Playground;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/?envType=problem-list-v2&envId=monotonic-stack
public class NextGreaterElement {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            int[] result = new int[nums1.length];
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            for(int i= nums2.length-1; i>=0; i--){
                int curr = nums2[i];
                while(!stack.isEmpty() && stack.peek() <= curr){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(curr, -1);
                }else{
                    map.put(curr, stack.peek());
                }
                stack.push(curr);
            }

            for(int i=0; i<nums1.length; i++){
                result[i] = map.get(nums1[i]);
            }

            return result;
        }
    }
}
