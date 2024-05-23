package Playground;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/solutions/2651338/java-easy-by-binary-search/
public class FindKClosestElement {

    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> result = new ArrayList<>();
            int low = 0;
            int high = arr.length-1;

            while(high - low >= k){
                int left = Math.abs(arr[low] - x);
                int right = Math.abs(arr[high] - x);

                if(left <= right){
                    high--;
                }else{
                    low++;
                }
            }

            while(low <= high){
                result.add(arr[low]);
                low++;
            }

            return result;

        }
    }
}
