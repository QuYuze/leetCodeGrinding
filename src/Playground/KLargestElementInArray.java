package Playground;

import java.util.Random;

//https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/2180600/a-guide-to-quick-select-java/

public class KLargestElementInArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            int result = quickSelect(nums, 0, nums.length-1, nums.length-k);

            return result;
        }

        private int quickSelect(int[] nums, int left, int right, int k){
            if(left == right){
                return nums[left];
            }

            int pIndex = new Random().nextInt(right-left+1) + left;
            pIndex = partition(nums, left, right, pIndex);

            if(k == pIndex){
                return nums[k];
            }else if(pIndex < k){
                pIndex++;
                while(pIndex < k && nums[pIndex] == nums[pIndex-1]){
                    pIndex++;
                }
                return quickSelect(nums, pIndex, right, k);
            }else{
                pIndex--;
                while(pIndex > k && nums[pIndex] == nums[pIndex+1]){
                    pIndex--;
                }
                return quickSelect(nums, left, pIndex, k);
            }
        }

        private int partition(int[] nums, int left, int right, int pIndex){
            int pivot = nums[pIndex];
            swap(nums, pIndex, right);
            pIndex = left;

            for(int i=left; i<=right; i++){
                if(nums[i] <= pivot){
                    swap(nums, i, pIndex++);
                }
            }

            return pIndex-1;
        }

        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
