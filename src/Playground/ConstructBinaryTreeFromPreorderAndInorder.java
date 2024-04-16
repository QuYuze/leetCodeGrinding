package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/1258712/js-python-java-c-easy-recursive-solution-w-explanation

public class ConstructBinaryTreeFromPreorderAndInorder {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            TreeNode root;

            HashMap<Integer, Integer> inorderMap = new HashMap<>();

            for(int i=0; i<inorder.length; i++){
                inorderMap.put(inorder[i], i);
            }

            root = construct(preorder, inorderMap, 0, inorder.length-1, 0);



            return root;

        }

        private TreeNode construct(int[] preorder, HashMap<Integer, Integer> inorderMap, int left, int right, int rootIndex){
            int rootInorderIndex = inorderMap.get(preorder[rootIndex]);
            TreeNode root = new TreeNode(preorder[rootIndex]);
            int leftLength = 0;
            if(left < rootInorderIndex){
                leftLength = rootInorderIndex - left;
                root.left = construct(preorder, inorderMap, left, rootInorderIndex-1, rootIndex+1);
            }

            if(right>rootInorderIndex){
                root.right = construct(preorder, inorderMap, rootInorderIndex+1, right, leftLength+rootIndex+1);
            }

            return root;

        }
    }
}
