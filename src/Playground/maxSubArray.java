package Playground;

public class maxSubArray {
    /*
    https://leetcode.com/problems/maximum-subarray/solutions/3666304/beats-100-c-java-python-beginner-friendly
     */

    public int maxSubArray(int[] nums) {
        int result = 0;
        int curr = 0;
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            curr += nums[i];
            if(curr < 0){
                if(curr>max){
                    max = curr;
                }
                curr = 0;
            }else{
                if(curr > max){
                    max = curr;
                }
            }
        }
        result = max;
        return result;

    }
}
