package Playground;

//https://leetcode.com/problems/trapping-rain-water/solutions/5126477/video-keep-max-height-on-the-both-side/

public class TrappingRainWater {
    class Solution {
        public int trap(int[] height) {

            if(height.length < 3){
                return 0;
            }

            int result = 0;
            int left = 0;
            int right = height.length - 1;
            int leftMax = height[0];
            int rightMax = height[height.length - 1];

            while(left < right){

                if(leftMax < rightMax){
                    left++;
                    if(height[left] < leftMax){
                        result += leftMax - height[left];
                    }else if(height[left] > leftMax){
                        leftMax = height[left];
                    }

                }else{
                    right--;
                    if(height[right] < rightMax){
                        result += rightMax - height[right];
                    }else if(height[right] > rightMax){
                        rightMax = height[right];
                    }

                }
            }

            return result;
        }


    }
}
