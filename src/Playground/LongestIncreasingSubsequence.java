package Playground;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int result = 1;

            if(nums.length==1){
                return result;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for(int i=0; i<nums.length; i++){

                int curr = nums[i];
                for(int j=i-1; j>=0; j--){
                    int currLength = 1;
                    if(nums[j]<curr){
                        currLength += dp[j];
                    }
                    dp[i] = currLength > dp[i] ? currLength : dp[i];
                }

                result = dp[i] > result ? dp[i] : result;
            }

            return result;
        }
    }

    //use binary search to reduce the complexity to O(nlogn)
    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 1){
                return 1;
            }

            ArrayList<Integer> result = new ArrayList<>();

            for(int n : nums){
                if(result.isEmpty() || result.get(result.size()-1) < n){
                    result.add(n);
                }else if(result.get(result.size()-1) == n){
                    continue;
                }else{
                    int index = search(result, n);
                    result.set(index, n);
                }
            }

            return result.size();
        }

        private int search(ArrayList<Integer> result, int curr){
            int left = 0;
            int right = result.size()-1;

            while(left < right){
                int mid = left + (right - left) / 2;
                if(result.get(mid) == curr){
                    return mid;
                }else if(result.get(mid) > curr){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
