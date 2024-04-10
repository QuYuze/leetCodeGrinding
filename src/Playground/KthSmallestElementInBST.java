package Playground;

import java.util.Stack;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {

            int result = 0;

            if(k==1&&root.left==null&&root.right==null){
                return root.val;
            }

            Stack<TreeNode> stack = new Stack<>();

            while(root!=null||!stack.isEmpty()){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    k--;
                    if(k==0){
                        return root.val;
                    }
                    root = root.right;
                }

            }


            return result;

        }
    }
}
