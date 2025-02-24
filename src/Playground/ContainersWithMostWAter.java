package Playground;

//https://leetcode.com/problems/container-with-most-water/

public class ContainersWithMostWAter {
    class Solution {
        public int maxArea(int[] height) {
            int result = -9999;
            int left = 0;
            int right = height.length-1;

            while(left < right){
                int leftHeight = height[left];
                int rightHeight = height[right];
                int currArea = (right - left) * Math.min(leftHeight, rightHeight);
                result = currArea > result ? currArea : result;

                if(leftHeight < rightHeight){
                    left++;
                }else{
                    right--;
                }
            }


            return result;
        }
    }
}
