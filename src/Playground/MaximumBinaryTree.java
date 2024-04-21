package Playground;


//https://leetcode.com/problems/maximum-binary-tree/solutions/3216908/java-solution-with-recursion-easy-to-understand/
public class MaximumBinaryTree {

    class Solution {


        public TreeNode constructMaximumBinaryTree(int[] nums) {

            TreeNode root = null;

            root = construct(nums, 0, nums.length-1);

            return root;
        }

        private TreeNode construct(int[] nums, int left, int right){

            if(left>right){
                return null;
            }

            int max = -1;
            int maxIndex = -1;

            for(int i=left; i<=right; i++){
                if(nums[i]>max){
                    max = nums[i];
                    maxIndex = i;
                }
            }

            TreeNode root = new TreeNode(max);

            root.left = construct(nums, left, maxIndex-1);

            root.right = construct(nums, maxIndex+1, right);


            return root;

        }
    }
}
